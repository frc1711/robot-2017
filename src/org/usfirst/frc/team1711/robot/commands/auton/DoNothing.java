package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DoNothing extends Command
{
	public DoNothing()
	{
		requires(Robot.driveSystem);
		requires(Robot.leftShooter);
		requires(Robot.rightShooter);
	}
	
	protected void initialize()
	{
		
	}
	
	protected void execute()
	{
		Robot.driveSystem.stopMotors();
		Robot.leftShooter.stopShooter();
		Robot.rightShooter.stopShooter();
	}
	
	protected boolean isFinished() 
	{
		return false;
	}
	
	protected void end()
	{
		
	}
	
	protected void interrupted()
	{
		
	}
	
}