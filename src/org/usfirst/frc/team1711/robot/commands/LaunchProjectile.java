package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LaunchProjectile extends Command
{
	
	public LaunchProjectile()
	{
		requires(Robot.shooter);
	}
	
	protected void initialize()
	{
	}
	
	protected void execute()
	{
			//.5 is arbitrary testing will reveal the proper value 
			Robot.shooter.shoot(.5);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end()
	{
		Robot.shooter.shoot(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}