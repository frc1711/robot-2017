package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.commands.DriveDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearAuton extends CommandGroup {

    public GearAuton() {
        addSequential(new DriveDistance(60, 0.50));
        Robot.driveSystem.zeroEncoders();
        addSequential(new DriveDistance(20, 0.25));
    }
}
