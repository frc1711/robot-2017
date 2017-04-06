package org.usfirst.frc.team1711.robot.commands.intake;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command controls the intake of fuel into the robot
 * It is run off of a trigger on a joystick button
 */
public class Absorb extends Command {

	/**
	 * Declares subsystem dependencies for this command
	 * This command requires the intake subsystem
	 */
    public Absorb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Run the motor controlling the intake at 75% speed
     */
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.absorb(0.75);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    /**
     * Set the speed on the intake motor to zero
     */
    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.absorb(0);
    }

    /**
     * Set the speed on the intake motor to zero
     */
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.absorb(0);
    }
}
