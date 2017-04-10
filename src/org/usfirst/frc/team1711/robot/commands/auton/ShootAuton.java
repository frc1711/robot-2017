package org.usfirst.frc.team1711.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootAuton extends CommandGroup {

    public ShootAuton(int side) {
        addSequential(new DriveDistance(20.0, 0.5));
        if(side == 1)
        	addSequential(new TurnRight(50.0));
        else if(side == 0)
        	addSequential(new TurnLeft(50.0));
        addSequential(new TimedShoot(2.5));
        addParallel(new TimedShoot(8.0));
        addParallel(new TimedAgitate(8.0));
    }
}
