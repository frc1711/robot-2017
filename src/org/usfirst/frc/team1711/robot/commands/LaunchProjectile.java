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
			//shoot real quick
			Robot.shooter.shoot(1);
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