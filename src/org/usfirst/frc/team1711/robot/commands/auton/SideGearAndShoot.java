package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.commands.TimedAgitate;
import org.usfirst.frc.team1711.robot.commands.TimedShoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideGearAndShoot extends CommandGroup {

    public SideGearAndShoot() {
//    	addSequential(new TimedDrive(5.261)); //121 inches
//       addSequential(new TurnRight(50.0));
//        addSequential(new TimedDrive(1.957)); //45 inches
//        addSequential(new HavePatience(4.0));
        addSequential(new TimedAgitate(0.5));
        addParallel(new TimedAgitate(3.0));
        addParallel(new TimedShoot(3.0));
    }
}
