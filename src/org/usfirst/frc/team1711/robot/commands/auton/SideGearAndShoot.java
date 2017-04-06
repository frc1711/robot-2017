package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.commands.DriveDistance;
import org.usfirst.frc.team1711.robot.commands.HavePatience;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideGearAndShoot extends CommandGroup {
	
    public SideGearAndShoot(int side) {
    	addSequential(new DriveDistance(121.0, 0.20));
//        addSequential(new TurnLeft(50.0));
    	if(side == 0)
    		addSequential(new TurnNoGyro(0.5, 50.0, "RIGHT"));
    	else if(side == 1)
    		addSequential(new TurnNoGyro(0.5, 50.0, "LEFT"));
//        addSequential(new TimedDrive(1.957)); //45 inches
    	addSequential(new DriveDistance(45.0, 0.20));
        addSequential(new HavePatience(4.0));
        addSequential(new TimedAgitate(0.5));
        addParallel(new TimedAgitate(3.0));
        addParallel(new TimedShoot(3.0));
    }
}
