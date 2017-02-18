package org.usfirst.frc.team1711.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SpinAgitators extends CommandGroup {

    public SpinAgitators() 
    {
    	addParallel(new SpinLeftAgitator());
    	addParallel(new SpinRightAgitator());
    }
}
