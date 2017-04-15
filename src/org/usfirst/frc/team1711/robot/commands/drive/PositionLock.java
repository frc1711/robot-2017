package org.usfirst.frc.team1711.robot.commands.drive;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PositionLock extends Command {

    public PositionLock()
    {
        requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.driveSystem.zeroEncoders();
    	Robot.driveSystem.enablePositionMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.driveSystem.setSetpoint(Robot.driveSystem.getEncoders());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.driveSystem.disablePositionMode();
    	Robot.driveSystem.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	Robot.driveSystem.disablePositionMode();
    	Robot.driveSystem.stopMotors();
    }
}
