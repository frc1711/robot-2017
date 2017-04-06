package org.usfirst.frc.team1711.robot.commands.agitators;

import org.usfirst.frc.team1711.robot.MagicNumbers;
import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class controls the right agitator
 */
public class SpinRightAgitator extends Command {

	/**
	 * Declares the subsystem dependencies of this command
	 * This command requires the right agitator
	 */
    public SpinRightAgitator() {
        requires(Robot.rightAgitator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Runs the agitator at a speed set in the constants file
     */
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.rightAgitator.agitate(MagicNumbers.agitatorSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    /**
     * Sets the power of the agitator motor to zero
     */
    // Called once after isFinished returns true
    protected void end() {
    	Robot.rightAgitator.agitate(0);
    }

    /**
     * Sets the power of the agitator motor to zero
     */
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.rightAgitator.agitate(0);
    }
}
