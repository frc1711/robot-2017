package org.usfirst.frc.team1711.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**7251, 68 (left), 
 *
 */
public class SideGearAndShoot extends CommandGroup {
	
    public SideGearAndShoot(int side) {
    	addSequential(new DriveDistance(125.0, 0.20));
//        addSequential(new TurnLeft(50.0));
    	if(side == 1)
//    		addSequential(new TurnNoGyro(0.5, 50.0, "RIGHT"));
    		addSequential(new TurnRight(76.0));
    	else if(side == 0)
//    		addSequential(new TurnNoGyro(0.5, 50.0, "LEFT"));
    		addSequential(new TurnLeft(76.0));
    	addSequential(new DriveDistance(114.5, 0.20));
        addSequential(new HavePatience(4.0));
        addSequential(new TimedAgitate(0.5));
        addParallel(new TimedAgitate(3.0));
        addParallel(new TimedShoot(3.0));
    }
}
