package org.usfirst.frc.team1711.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team1711.robot.commands.DriveJoystickTest;
import org.usfirst.frc.team1711.robot.commands.RawJoystickDrive;
import org.usfirst.frc.team1711.robot.commands.SpinAgitator;
import org.usfirst.frc.team1711.robot.commands.TestCommands;
import org.usfirst.frc.team1711.robot.subsystems.Agitator;
import org.usfirst.frc.team1711.robot.subsystems.DriveSystem;
import org.usfirst.frc.team1711.robot.vision.GripPipeline;
import org.usfirst.frc.team1711.robot.vision.VisionServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveSystem driveSystem;
	public static VisionServer vision;
	public static OI oi;
<<<<<<< HEAD
	
	VisionThread visionThread;
=======
	public static Agitator agitator;
>>>>>>> branch 'master' of https://github.com/frc1711/robot-2017.git

	Command autonomousCommand;
	Command teleopDrive;
	Command testingGroup;
	Command spinAgitator;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init(); //this line needs to be first
		driveSystem = new DriveSystem();
		teleopDrive = new RawJoystickDrive();
		testingGroup = new DriveJoystickTest();
		agitator = new Agitator();
		spinAgitator = new SpinAgitator();
		oi = new OI();
		vision = new VisionServer();
		chooser.addDefault("Default Auto", new RawJoystickDrive());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	    
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		teleopDrive.cancel();
		testingGroup.cancel();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
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
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		spinAgitator.execute();
		Scheduler.getInstance().run();
//		System.out.println("Front left: " + RobotMap.frontLeftDriveCANTalon.get());
//		System.out.println("Front right: " + RobotMap.frontRightDriveCANTalon.get());
//		System.out.println("Rear left: " + RobotMap.rearLeftDriveCANTalon.get());
//		System.out.println("Rear right: " + RobotMap.frontLeftDriveCANTalon.get());
		Thread visionThread = new Thread(){
			public void run()
			{
				vision.visionFeed();
			}
		};
		visionThread.start(); 
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		//this is basically our debugger
		LiveWindow.run();
//		testingGroup.start();
//		System.out.println("Drive stick magnitude: " + RobotMap.driverController.getMagnitude());
//		System.out.println("Drive direction in degrees: " + RobotMap.driverController.getDirectionDegrees());

	}
}
