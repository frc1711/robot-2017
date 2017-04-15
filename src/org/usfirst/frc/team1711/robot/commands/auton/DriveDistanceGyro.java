package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistanceGyro extends Command {

	double speed;
	double distance;
	
    public DriveDistanceGyro(double distance, double speed) 
    {
        requires(Robot.driveSystem);
        this.speed = -speed;
        this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.driveSystem.resetGyro();
    	Robot.driveSystem.zeroEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double currentHeading = Robot.driveSystem.getGyroAngle();
    	double correction = -1 * (currentHeading / 100);
    	Robot.driveSystem.drive.drive(speed, correction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if((Robot.driveSystem.getLeftDriveEncoder() / RobotMap.pulsesPerInchLeft >= distance))
        	return true;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
