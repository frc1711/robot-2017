package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnNoGyro extends Command
{
	double speed;
	double angle;
	final double pulsesPerDegree;
	boolean left;
	
	public TurnNoGyro(double speed, double angle, String direction)
	{
		this.speed = speed;
		this.angle = angle;
		
		//test to find this
		pulsesPerDegree = 0;
		
		if(direction.equals("RIGHT"))
		{
			this.left = false;
		}
		else if(direction.equals("LEFT"))
		{
			this.left = true;
		}
	}
	
	protected void initialize()
	{
		Robot.driveSystem.zeroEncoders();
	}
	
	protected void execute()
	{
		if(left)
		{
			Robot.driveSystem.turnLeft(speed);
		}
		else
		{
			Robot.driveSystem.turnRight(speed);
		}
	}

	@Override
	protected boolean isFinished() 
	{
		if(left)
		{
			if((Robot.driveSystem.getLeftDriveEncoder() / pulsesPerDegree) >= angle)
				return true;
			else
				return false;
		}
		else
		{
			if((Robot.driveSystem.getRightDriveEncoder() / pulsesPerDegree) >= angle)
				return true;
			else
				return false;
		}
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