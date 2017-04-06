package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedDrive extends TimedCommand {

    public TimedDrive(double timeout) {
        super(timeout);
        requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSystem.driveForward(0.25);
    }

    // Called once after timeout
    protected void end() {
    	Robot.driveSystem.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
