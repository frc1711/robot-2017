package org.usfirst.frc.team1711.robot.commands.auton;

import org.usfirst.frc.team1711.robot.commands.TimedDrive;
import org.usfirst.frc.team1711.robot.commands.TurnLeft;
import org.usfirst.frc.team1711.robot.commands.TurnRight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideGearAuton extends CommandGroup {

	
    public SideGearAuton(boolean boiler) 
    {	
    	addSequential(new TimedDrive(5.261)); //121 inches
    	
    	if(boiler)
    		addSequential(new TurnRight(50.0));
    	else
    		addSequential(new TurnLeft(50.0));
    	
    	addSequential(new TimedDrive(2.043));
    }
}
