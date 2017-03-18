package org.usfirst.frc.team1711.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;
import org.usfirst.frc.team1711.robot.networking.*;

/** This class automatically aligns the robot in order to hit the high goal
 * @author Sam
 */
public class AutoAim extends Command {

	public boolean isDone = false;
	public double sweetSpot = 0; //optimal distance from the target when shooting
	
	/**Declares the required subsystems for this command
	 * This command requires the drive system
	 */
    public AutoAim() {
        requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**Checks the angle in the network table (given by the Raspberry Pi) to see if the target is right, left, or center.
     * If the target is too far away, the robot will drive forward until the distance being returned from the network table
     * equals the desired distance for maximum accuracy.
     * If the target to the right or left, the robot will turn using the gyro to check it's position, until the target is in
     * the correct position.
     */
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 /*   	
    	if(Robot.piNet.getDistance() < sweetSpot)
    	{
    		Robot.driveSystem.driveForward(.5);
    	}
    	
    	if(Robot.piNet.getAngleDifference() < 0)
    	{
    		Robot.driveSystem.turnLeft(.25);
    	}
    	isDone = true;
    	
    	if(Robot.piNet.getAngleDifference() > 0)
    	{
    		Robot.driveSystem.turnRight(.25);
    	}
    	isDone = true; */
    }
    
    /**
     * When the target is in the correct position, this will return true and the command will finish
     */
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
