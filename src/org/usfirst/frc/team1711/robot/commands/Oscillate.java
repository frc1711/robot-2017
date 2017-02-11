package org.usfirst.frc.team1711.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Oscillate extends CommandGroup {

    public Oscillate() {
        addSequential(new SpinAgitator(.25));
        addSequential(new SpinAgitator(-.25));
    }
}
