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
import org.usfirst.frc.team1711.robot.networking.PiNetworkTable;
import org.usfirst.frc.team1711.robot.subsystems.Agitator;
import org.usfirst.frc.team1711.robot.subsystems.DriveSystem;
import org.usfirst.frc.team1711.robot.subsystems.Intake;
import org.usfirst.frc.team1711.robot.subsystems.Lift;
import org.usfirst.frc.team1711.robot.subsystems.Shooter;

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
	
	Command autonomousCommand;
	Command teleopDrive;
	Command launchProjectile;
	Command oscillator;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code. 00
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
		piNet = new PiNetworkTable();
		oi = new OI(); //this line needs to be last
		
		chooser.addDefault("Default Auto", new RawJoystickDrive());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser); 
		
		driveSystem.resetGyro();
//		CameraServer.getInstance().startAutomaticCapture();
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
	}

	/**
	 * This autonomous (along with the chooser code      above) shows how to select
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

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		teleopDrive.start();
		launchProjectile.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
//		leftShooter.dashBoardControl();
//		rightShooter.dashBoardControl();
		System.out.println(RobotMap.driverController.getRawButton(1));
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
