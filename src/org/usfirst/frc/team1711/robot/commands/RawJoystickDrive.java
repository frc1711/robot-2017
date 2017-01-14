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
		//I don't know the size of the dead zone or the correct axis for rotation
		//these are the values from 2015, we should be using the same physical joystick
		if(RobotMap.driverController.getMagnitude() > .08 || Math.abs(RobotMap.driverController.getRawAxis(4)) > .08)
		{
			Robot.driveSystem.polarDrive(RobotMap.driverController.getRawAxis(1), RobotMap.driverController.getDirectionDegrees(), RobotMap.driverController.getRawAxis(4));
		//	Robot.driveSystem.cartesianDrive(RobotMap.driverController.getRawAxis(0), -(RobotMap.driverController.getRawAxis(1)), rotation, gyroAngle);
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end()
	{
		Robot.driveSystem.polarDrive(0, 0, 0);
	}
	
}