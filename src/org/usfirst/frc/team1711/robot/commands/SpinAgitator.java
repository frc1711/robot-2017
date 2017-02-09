package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinAgitator extends Command
{
	double speed;
	
	public SpinAgitator(double speed)
	{
		requires(Robot.agitator);
		this.speed = speed;
		setTimeout(1);
	}
	
	protected void initialize()
	{
	}
	
	protected void execute()
	{ 
		Robot.agitator.agitate(speed);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	protected void end()
	{
		Robot.agitator.agitate(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}