package org.usfirst.frc.team1711.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1711.robot.commands.auton.DoNothing;
import org.usfirst.frc.team1711.robot.commands.auton.DriveDistance;
import org.usfirst.frc.team1711.robot.commands.auton.DriveDistanceGyro;
import org.usfirst.frc.team1711.robot.commands.auton.ShootAuton;
import org.usfirst.frc.team1711.robot.commands.auton.SideGearAndShoot;
import org.usfirst.frc.team1711.robot.commands.auton.SideGearAuton;
import org.usfirst.frc.team1711.robot.commands.drive.RawJoystickDrive;
import org.usfirst.frc.team1711.robot.commands.meta.CurrentMonitor;
import org.usfirst.frc.team1711.robot.commands.meta.DashboardInput;
import org.usfirst.frc.team1711.robot.commands.shooters.LaunchProjectile;
import org.usfirst.frc.team1711.robot.networking.PiNetworkTable;
import org.usfirst.frc.team1711.robot.subsystems.Agitator;
import org.usfirst.frc.team1711.robot.subsystems.DriveSystem;
import org.usfirst.frc.team1711.robot.subsystems.Intake;
import org.usfirst.frc.team1711.robot.subsystems.Lift;
import org.usfirst.frc.team1711.robot.subsystems.Shooter;
import org.opencv.core.Mat;
import org.usfirst.frc.team1711.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveSystem driveSystem;
	public static OI oi;	
	public static Shooter leftShooter;
	public static Shooter rightShooter;
	public static Agitator leftAgitator;
	public static Agitator rightAgitator;
	public static Intake intake;
	public static Lift lift;
	public static MagicNumbers magic;
	public static PiNetworkTable piNet;
	
	Command autonomousCommand;
	Command teleopDrive;
	Command launchProjectile;
	Command dashboardInput;
	Command currentMonitoring;
	SendableChooser<Command> chooser;
	SendableChooser<Integer> cameraChooser;
	
	int cameraChosen;
	
	boolean testMode = true;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override 
	public void robotInit() {
		RobotMap.init(); //this line needs to be first
		driveSystem = new DriveSystem();
		leftShooter = new Shooter(RobotMap.leftShooterMotor);
		rightShooter = new Shooter(RobotMap.rightShooterMotor);
		lift = new Lift();
		intake = new Intake();
		teleopDrive = new RawJoystickDrive();
		leftAgitator = new Agitator(RobotMap.leftAgitatorMotor);
		rightAgitator = new Agitator(RobotMap.rightAgitatorMotor);
		launchProjectile = new LaunchProjectile();
		magic = new MagicNumbers();
		dashboardInput = new DashboardInput();
		currentMonitoring = new CurrentMonitor();
		chooser = new SendableChooser<>();
		cameraChooser = new SendableChooser<>();
		piNet = new PiNetworkTable();
		oi = new OI(); //this line needs to be last
			
		chooser.addDefault("Do Nothing", new DoNothing());
		chooser.addObject("Cross baseline", new DriveDistance(200, 0.25));
		chooser.addObject("Straight Gear", new DriveDistance(100.0, 0.25));
		chooser.addObject("Right side gear", new SideGearAuton(SideGearAuton.RIGHT));
		chooser.addObject("Left side gear", new SideGearAuton(SideGearAuton.LEFT));
		chooser.addObject("Right side gear and shoot", new SideGearAndShoot(SideGearAuton.RIGHT));
		chooser.addObject("Left side gear and shoot", new SideGearAndShoot(SideGearAuton.LEFT));
		chooser.addObject("Right shoot auton", new ShootAuton(SideGearAuton.RIGHT));
		chooser.addObject("Left shoot auton", new ShootAuton(SideGearAuton.LEFT));
		chooser.addObject("Gyro corrected", new DriveDistanceGyro(90.0, 0.3));
		SmartDashboard.putData("Auto mode", chooser); 
		
		cameraChooser.addDefault("Axis camera", 0);
		cameraChooser.addObject("USB Camera", 1);
		SmartDashboard.putData("Camera chooser", cameraChooser);
		
		new Thread(() ->
				{
					UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();
					cam0.setExposureManual(40);
					cam0.setResolution(640, 480);
					CvSink cvsink = CameraServer.getInstance().getVideo();
					CvSource outputStream = CameraServer.getInstance().putVideo("cam0", 640, 480);
					Mat source = new Mat();
					
					while(!Thread.interrupted())
					{
						cvsink.grabFrame(source);
						outputStream.putFrame(source);
					}
				}).start();
//		CameraServer.getInstance().addCamera(cam0);
	//	CameraServer.getInstance().startAutomaticCapture();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		teleopDrive.cancel();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
		if(testMode)
		{
			System.out.println("Gyro: " + driveSystem.getGyroAngle());
		}
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		autonomousCommand = chooser.getSelected();
//		piNet.setCamera(cameraChooser.getSelected());
		
		driveSystem.resetGyro();
		driveSystem.zeroEncoders();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		if(testMode)
		{
			System.out.println("Left Encoder: " + driveSystem.getLeftDriveEncoder());
			System.out.println("Gyro: " + driveSystem.getGyroAngle());
		}		
	}

	@Override
	public void teleopInit() {
		//stop auton when teleop starts (optional)
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		teleopDrive.start();
		launchProjectile.start();
		dashboardInput.start();
		currentMonitoring.start();
		driveSystem.zeroEncoders();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		if(testMode)
		{
			System.out.println("Gyro: " + driveSystem.getGyroAngle());
			System.out.println("Left encoder: " + driveSystem.getLeftDriveEncoder());
			System.out.println("Right encoder: " + driveSystem.getRightDriveEncoder());
		}		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
