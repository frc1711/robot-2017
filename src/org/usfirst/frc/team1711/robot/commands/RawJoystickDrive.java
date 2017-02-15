package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RawJoystickDrive extends Command
{
	double rotation = 0;
	
	public RawJoystickDrive()
	{
		requires(Robot.driveSystem);
	}
	
	protected void initialize()
	{
		Robot.driveSystem.resetGyro();
	}
	
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
	
	protected void end()
	{
		Robot.driveSystem.stopMotors();
	}
	
}