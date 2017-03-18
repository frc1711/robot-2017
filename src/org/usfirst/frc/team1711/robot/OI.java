package org.usfirst.frc.team1711.robot;

import org.usfirst.frc.team1711.robot.commands.Absorb;
import org.usfirst.frc.team1711.robot.commands.BackwardsIntake;
import org.usfirst.frc.team1711.robot.commands.JoystickDriveBackwards;
import org.usfirst.frc.team1711.robot.commands.LaunchProjectile;
import org.usfirst.frc.team1711.robot.commands.LiftLifter;
import org.usfirst.frc.team1711.robot.commands.RawJoystickDrive;
import org.usfirst.frc.team1711.robot.commands.SpinAgitators;
import org.usfirst.frc.team1711.robot.commands.SpinLeftAgitator;
import org.usfirst.frc.team1711.robot.commands.SpinRightAgitator;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	Button intakeButton = new JoystickButton(RobotMap.driverController, 1);
	Button doubleAgitatorButton = new JoystickButton(RobotMap.driverController, 2);
	Button liftButton = new JoystickButton(RobotMap.driverController, 4);
	Button leftAgitatorButton = new JoystickButton(RobotMap.driverController, 6);
	Button rightAgitatorButton = new JoystickButton(RobotMap.driverController, 5);
//	Button goBackwardsButton = new JoystickButton(RobotMap.driverController, 3);
	Button backwardsIntakeButton = new JoystickButton(RobotMap.driverController, 7);
	
	private boolean isBackwards = false;
	
	public OI()
	{
		doubleAgitatorButton.whileHeld(new SpinAgitators());
		leftAgitatorButton.whileHeld(new SpinLeftAgitator());
		rightAgitatorButton.whileHeld(new SpinRightAgitator());
		
		liftButton.whileHeld(new LiftLifter());
		intakeButton.whileHeld(new Absorb());
		backwardsIntakeButton.whileHeld(new BackwardsIntake());
		
/*		if(isBackwards)
		{
			goBackwardsButton.whenPressed(new RawJoystickDrive());
			isBackwards = false;
		}
		else
		{
			goBackwardsButton.whenPressed(new JoystickDriveBackwards());
			isBackwards = true;
		} */
	}
}
