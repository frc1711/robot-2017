package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.MagicNumbers;
import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedAgitate extends TimedCommand {

    public TimedAgitate(double timeout) {
        super(timeout);
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
    	Robot.leftAgitator.agitate(0);
    	Robot.rightAgitator.agitate(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.leftAgitator.agitate(0);
    	Robot.rightAgitator.agitate(0);
    }
}
