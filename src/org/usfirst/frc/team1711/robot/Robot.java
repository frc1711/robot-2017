package org.usfirst.frc.team1711.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.usfirst.frc.team1711.robot.commands.LaunchProjectile;
import org.usfirst.frc.team1711.robot.commands.RawJoystickDrive;
import org.usfirst.frc.team1711.robot.commands.auton.DoNothing;
import org.usfirst.frc.team1711.robot.networking.PiNetworkTable;
import org.usfirst.frc.team1711.robot.subsystems.Agitator;
import org.usfirst.frc.team1711.robot.subsystems.DriveSystem;
import org.usfirst.frc.team1711.robot.subsystems.Intake;
import org.usfirst.frc.team1711.robot.subsystems.Lift;
import org.usfirst.frc.team1711.robot.subsystems.Shooter;
import org.usfirst.frc.team1711.robot.subsystems.ShooterEncoder;
import org.usfirst.frc.team1711.robot.commands.*;

// serial port test
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Preferences prefs;
	public static DriveSystem driveSystem;
	public static OI oi;	
	public static Shooter leftShooter;
	public static Shooter rightShooter;
	VisionThread visionThread;
	public static Agitator leftAgitator;
	public static Agitator rightAgitator;
	public static Intake intake;
	public static Lift lift;
	public static PiNetworkTable piNet;
	public static ShooterEncoder shooterEncoder;
	public static MagicNumbers magic;
	
	Command autonomousCommand;
	Command teleopDrive;
	Command launchProjectile;
	Command dashboardInput;
	Command currentMonitoring;
	SendableChooser<Command> chooser = new SendableChooser<>();

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
		shooterEncoder = new ShooterEncoder();
		lift = new Lift();
		intake = new Intake();
		teleopDrive = new RawJoystickDrive();
		leftAgitator = new Agitator(RobotMap.leftAgitatorMotor);
		rightAgitator = new Agitator(RobotMap.rightAgitatorMotor);
		launchProjectile = new LaunchProjectile();
		magic = new MagicNumbers();
		piNet = new PiNetworkTable();
		dashboardInput = new DashboardInput();
		currentMonitoring = new CurrentMonitor();
		oi = new OI(); //this line needs to be last
			
		chooser.addDefault("Do Nothing", new DoNothing());
		chooser.addObject("Cross baseline", new DriveDistance(112, 0.25));
		SmartDashboard.putData("Auto mode", chooser); 
		
		CameraServer.getInstance().startAutomaticCapture("usb cam", "/dev/video0");
		CameraServer.getInstance().startAutomaticCapture("usb cam", "/dev/video1");
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
		System.out.println(driveSystem.getDriveEncoder());
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

		driveSystem.resetGyro();
		driveSystem.zeroEncoder();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(driveSystem.getDriveEncoder());
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
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(driveSystem.getGyroAngle());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		//this is basically our debugger
		LiveWindow.run();
	}
}
