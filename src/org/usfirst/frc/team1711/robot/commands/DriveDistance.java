package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {

	public double distance;
	public double speed;
	
    public DriveDistance(double distance, double speed) {
        requires(Robot.driveSystem);
        this.distance = distance;
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.driveSystem.zeroEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSystem.driveForward(speed);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if((Robot.driveSystem.getDriveEncoder() * RobotMap.distancePerPulse) >= distance)
        	return true;
        else
        	return false;
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
