package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveJoystickTest extends Command
{
	public DriveJoystickTest()
	{
		//it does not technically require this right now, however it is likely that this will be extended to test actual drive
		//functionality, therefore I want to put this here now so that it's established that this is solely the tester for
		//anything to do with driving (i.e. manipulator testing will go in a separate command) and also I want it to require
		//the subsystem so that the robot can't be actually driving in any sort of 'normal' mode while we are testing
		requires(Robot.driveSystem);
	}
	
	protected void initialize()
	{
		
	}
	
	protected void execute()
	{
		System.out.println("Drive stick magnitude: " + RobotMap.driverController.getMagnitude());
		System.out.println("Drive direction in degrees: " + RobotMap.driverController.getDirectionDegrees());
		System.out.println();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end()
	{
		
	}
	
}