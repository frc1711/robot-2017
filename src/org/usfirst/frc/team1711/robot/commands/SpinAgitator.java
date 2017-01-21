package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinAgitator extends Command
{
	
	public SpinAgitator()
	{
		requires(Robot.agitator);
	}
	
	protected void initialize()
	{
	}
	
	public void execute()
	{
			//.5 is arbitrary testing will reveal the proper value 
			Robot.agitator.agitate(.5);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void end()
	{
		Robot.agitator.agitate(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}