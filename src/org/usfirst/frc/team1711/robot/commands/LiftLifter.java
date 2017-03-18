package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.MagicNumbers;
import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class controls the lifting mechanism
 */
public class LiftLifter extends Command {

	/**
	 * Declares all subsystem dependencies for this command
	 * This command requires the lifter
	 */
    public LiftLifter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Runs the lift at 75% power
     * The lift is controlled manually by a button on the driver controller
     */
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if(Robot.lift.getLimitSwitch() == false)
    		Robot.lift.runLift(0.90);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	if(Robot.lift.getLimitSwitch())
//       	return true;
        return false;
    }

    /**
     * Sets the power of the lifter motor to zero
     */
    // Called once after isFinished returns true
    protected void end() {
        	Robot.lift.runLift(0);
    }

    /**
     * Sets the power of the lifter motor to zero
     */
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lift.runLift(0);
    }
}
