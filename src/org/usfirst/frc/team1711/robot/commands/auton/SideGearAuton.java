package org.usfirst.frc.team1711.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideGearAuton extends CommandGroup {

	public static final int RIGHT = 0;
	public static final int LEFT = 1;
	
    public SideGearAuton(int side) 
    {	
    	addSequential(new DriveDistanceGyro(67.0, 0.25)); //121 inches
    	
    	if(side == 1)
//    		addSequential(new TurnNoGyro(0.5, 50.0, "LEFT"));
    		addSequential(new TurnRight(45.0));
    	else if(side == 0)
//    		addSequential(new TurnNoGyro(0.5, 50.0, "RIGHT"));
    		addSequential(new TurnLeft(50.0));
    	
    	//find this in inches and use encoders
    	addSequential(new DriveDistance(100.0, 0.25));
    }
}
