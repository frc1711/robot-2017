package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.commands.auton.TestTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideGearAuton extends CommandGroup {

    public SideGearAuton() {
        addSequential(new TimedDrive(5.261)); //121 inches
        addSequential(new TurnRight(50.0));
        addSequential(new TimedDrive(2.043));
    }
}
