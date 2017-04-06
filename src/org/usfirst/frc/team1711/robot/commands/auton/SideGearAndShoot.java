package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.commands.DriveDistance;
import org.usfirst.frc.team1711.robot.commands.HavePatience;
import org.usfirst.frc.team1711.robot.commands.TimedAgitate;
import org.usfirst.frc.team1711.robot.commands.TimedDrive;
import org.usfirst.frc.team1711.robot.commands.TimedShoot;
import org.usfirst.frc.team1711.robot.commands.TurnLeft;
import org.usfirst.frc.team1711.robot.commands.TurnRight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideGearAndShoot extends CommandGroup {

    public SideGearAndShoot() {
//    	addSequential(new TimedDrive(5.261)); //121 inches
    	addSequential(new DriveDistance(121.0, 0.20));
        addSequential(new TurnLeft(50.0));
//        addSequential(new TimedDrive(1.957)); //45 inches
        addSequential(new HavePatience(4.0));
        addSequential(new TimedAgitate(0.5));
        addParallel(new TimedAgitate(3.0));
        addParallel(new TimedShoot(3.0));
    }
}
