package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.MagicNumbers;
import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 * 
 */
public class TimedAgitator extends TimedCommand {

    public TimedAgitator(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.leftAgitator);
        requires(Robot.rightAgitator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.leftAgitator.agitate(MagicNumbers.agitatorSpeed);
    	Robot.rightAgitator.agitate(MagicNumbers.agitatorSpeed);
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
