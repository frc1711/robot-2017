package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class controls the basic teleop driving operation of the robot
 * @author Abigail
 *
 */
public class RawJoystickDrive extends Command
{
	double rotation = 0;
	
	/**
	 * Declares the required subsystem dependencies for this command
	 * This command requires the drive system
	 */
	public RawJoystickDrive()
	{
		requires(Robot.driveSystem);
	}
	
	/**
	 * This is called once before the command is run, in order to set the gyro on the drive base to zero
	 */
	protected void initialize()
	{
		Robot.driveSystem.resetGyro();
	}
	
	/**
	 * This checks the drivr joystick to see if it is outside of the dead zone, if it is, it uses joystick input to drive the
	 * robot with a basic arcade drive
	 */
	protected void execute()
	{
		if((RobotMap.driverController.getMagnitude() > .1))
		{
			Robot.driveSystem.arcadeDrive(RobotMap.driverController);
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Sets the motor power of all four drive motors to zero
	 */
	protected void end()
	{
		Robot.driveSystem.stopMotors();
	}
	
	protected void interrupted()
	{
		Robot.driveSystem.stopMotors();
	}
	
}