package org.usfirst.frc.team1711.robot.commands.agitators;

import org.usfirst.frc.team1711.robot.MagicNumbers;
import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class controls the left agitator
 */
public class SpinLeftAgitator extends Command {

	/**
	 * Declares the subsystem dependencies of this command
	 * This command requires the left agitator
	 */
    public SpinLeftAgitator() {
        requires(Robot.leftAgitator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Spins the left agitator at the speed set as the constant, universal agitator speed in the constants file
     */
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.leftAgitator.agitate(MagicNumbers.agitatorSpeed);
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
    	Robot.leftAgitator.agitate(0);
    }

    /**
     * Sets the power of the agitator motor to zero
     */
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.leftAgitator.agitate(0);
    }
}
