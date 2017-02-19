package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class reads values from the Power Distribution Panel and other robot components, and outputs them to the Smart
 * Dashboard for driver use.
 * @author Abigail
 *
 */
public class DashboardInput extends Command
{
	public DashboardInput()
	{
		
	}
	
	protected void initialize()
	{
		
	}
	
	/**
	 * Reads the current draw on the left and right shooters, and the temperature of the power distribution panel
	 * and outputs them to the Smart Dashboard.
	 *
	 */
	protected void execute()
	{
		//these should be shown on graphs or dials
		SmartDashboard.putNumber("Left shooter current draw", RobotMap.pdp.getCurrent(RobotMap.leftShooterPDP));
		SmartDashboard.putNumber("Right shooter current draw", RobotMap.pdp.getCurrent(RobotMap.rightShooterPDP));
		SmartDashboard.putNumber("PDP Temperature", RobotMap.pdp.getTemperature());
		//SmartDashboard.getNumber(); add something like this with an RPi counter
	}
	
	protected boolean isFinished()
	{
		return false;	
	}
	
	protected void end()
	{
		
	}
	
	protected void interrupted()
	{
		
	}
}