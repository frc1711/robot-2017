package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.MagicNumbers;
import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinAgitator extends Command
{
	
	public SpinAgitator()
	{
		requires(Robot.leftAgitator);
		requires(Robot.rightAgitator);
//		setTimeout(1);
	}
	
	protected void initialize()
	{
	}
	
	protected void execute()
	{ 
		Robot.leftAgitator.agitate(MagicNumbers.agitatorSpeed);
		Robot.rightAgitator.agitate(MagicNumbers.agitatorSpeed);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
//		return isTimedOut();
		return false;
	}
	
	protected void end()
	{
		Robot.leftAgitator.agitate(0);
		Robot.rightAgitator.agitate(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}