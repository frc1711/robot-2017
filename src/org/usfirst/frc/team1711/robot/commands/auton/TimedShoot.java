package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedShoot extends TimedCommand {

    public TimedShoot(double timeout) {
        super(timeout);
        requires(Robot.leftShooter);
        requires(Robot.rightShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.leftShooter.shoot(1.0);
    	Robot.rightShooter.shoot(1.0);
    }

    // Called once after timeout
    protected void end() {
    	Robot.leftShooter.shoot(0);
    	Robot.rightShooter.shoot(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.leftShooter.shoot(0);
    	Robot.rightShooter.shoot(0);
    }
}
