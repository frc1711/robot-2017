package org.usfirst.frc.team1711.robot.commands.agitators;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This is a command group to control both agitators
 * @author Abigail
 */
public class SpinAgitators extends CommandGroup {

	/**
	 * Spins up both agitators, is triggered by a joystick button separate from the button used for spinning up either
	 * individual agitator
	 */
    public SpinAgitators() 
    {
    	addParallel(new SpinLeftAgitator());
    	addParallel(new SpinRightAgitator());
    }
}
