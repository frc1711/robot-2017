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
    	addSequential(new TimedDrive(5.261)); //121 inches
    	
    	if(side == 0)
    		addSequential(new TurnNoGyro(0.5, 50.0, "LEFT"));
//    		addSequential(new TurnRight(50.0));
    	else if(side == 1)
    		addSequential(new TurnNoGyro(0.5, 50.0, "RIGHT"));
//    		addSequential(new TurnLeft(50.0));
    	
    	//find this in inches and use encoders
    	addSequential(new TimedDrive(2.043));
    }
}
