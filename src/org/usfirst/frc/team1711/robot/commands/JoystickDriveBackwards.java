package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class JoystickDriveBackwards extends Command
{
	public JoystickDriveBackwards()
	{
		requires(Robot.driveSystem);
	}
	
	protected void initialize()
	{
		
	}
	
	protected void execute()
	{
		if((RobotMap.driverController.getMagnitude()) > .1)
			Robot.driveSystem.backwardsArcade();
	}

	@Override
	protected boolean isFinished() 
	{
		return false;
	}
	
	protected void end()
	{
		Robot.driveSystem.stopMotors();
	}
	
	protected void interrupted()
	{
		Robot.driveSystem.stopMotors();
	}
}