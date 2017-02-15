package org.usfirst.frc.team1711.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;
import org.usfirst.frc.team1711.robot.networking.*;

/**
 *
 */
public class AutoAim extends Command {

	public boolean isDone = false;
	public double sweetSpot = 0;
	
    public AutoAim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(Robot.piNet.getDistance() < sweetSpot)
    	{
    		Robot.driveSystem.driveForward(.5);
    	}
    	
    	while(Robot.piNet.getAngleDifference() < 0)
    	{
    		Robot.driveSystem.turnLeft(.25);
    	}
    	isDone = true;
    	
    	while(Robot.piNet.getAngleDifference() > 0)
    	{
    		Robot.driveSystem.turnRight(.25);
    	}
    	isDone = true;
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
