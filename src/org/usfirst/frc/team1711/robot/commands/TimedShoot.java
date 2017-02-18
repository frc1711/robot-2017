package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.MagicNumbers;
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
      
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	
    	Robot.leftShooter.shoot(MagicNumbers.shooterSpeed);
    	Robot.rightShooter.shoot(MagicNumbers.shooterSpeed);
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { 
    }
}
