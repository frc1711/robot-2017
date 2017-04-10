package org.usfirst.frc.team1711.robot;

import org.usfirst.frc.team1711.robot.commands.agitators.SpinAgitators;
import org.usfirst.frc.team1711.robot.commands.agitators.SpinLeftAgitator;
import org.usfirst.frc.team1711.robot.commands.agitators.SpinRightAgitator;
import org.usfirst.frc.team1711.robot.commands.drive.JoystickDriveBackwards;
import org.usfirst.frc.team1711.robot.commands.drive.MacroDrive;
import org.usfirst.frc.team1711.robot.commands.drive.RawJoystickDrive;
import org.usfirst.frc.team1711.robot.commands.intake.Absorb;
import org.usfirst.frc.team1711.robot.commands.intake.BackwardsIntake;
import org.usfirst.frc.team1711.robot.commands.lifter.LiftLifter;
import org.usfirst.frc.team1711.robot.commands.shooters.LaunchProjectile;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	Button intakeButton = new JoystickButton(RobotMap.driverController, 1);
	Button doubleAgitatorButton = new JoystickButton(RobotMap.driverController, 2);
	Button liftButton = new JoystickButton(RobotMap.driverController, 4);
	Button leftAgitatorButton = new JoystickButton(RobotMap.driverController, 6);
	Button rightAgitatorButton = new JoystickButton(RobotMap.driverController, 5);
	Button goBackwardsButton = new JoystickButton(RobotMap.driverController, 3);
	Button backwardsIntakeButton = new JoystickButton(RobotMap.driverController, 7);
	Button macroDriveToggle = new JoystickButton(RobotMap.driverController, 8);
	
	public OI()
	{
		doubleAgitatorButton.whileHeld(new SpinAgitators());
		leftAgitatorButton.whileHeld(new SpinLeftAgitator());
		rightAgitatorButton.whileHeld(new SpinRightAgitator());
		
		liftButton.whileHeld(new LiftLifter());
		intakeButton.whileHeld(new Absorb());
		backwardsIntakeButton.whileHeld(new BackwardsIntake());
		
		macroDriveToggle.toggleWhenPressed(new MacroDrive());
		
		goBackwardsButton.toggleWhenPressed(new JoystickDriveBackwards());
	}
}
