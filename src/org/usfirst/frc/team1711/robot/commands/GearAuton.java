package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearAuton extends CommandGroup {

    public GearAuton() {
        addSequential(new DriveDistance(60, 0.50));
        Robot.driveSystem.zeroEncoder();
        addSequential(new DriveDistance(20, 0.25));
    }
}
