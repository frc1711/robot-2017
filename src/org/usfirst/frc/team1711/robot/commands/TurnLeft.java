package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnLeft extends Command {

	private double myAngle;
	private double desiredAngle;
	
    public TurnLeft(double desiredAngle) {
        requires(Robot.driveSystem);
        this.desiredAngle = desiredAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSystem.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSystem.turnLeft(0.5);
    	myAngle = Robot.driveSystem.getGyroAngle();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//needs to be tested!!!!!!!
    	if(myAngle <= desiredAngle)
        	return true;
        else
        {
        	System.out.println(Robot.driveSystem.getGyroAngle());
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveSystem.stopMotors();
    }
}
