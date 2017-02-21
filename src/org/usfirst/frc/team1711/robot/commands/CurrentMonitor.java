package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CurrentMonitor extends Command {

	public static double leftShooterCurrent;
	public static double rightShooterCurrent;
	
	public static final double leftShooterMax = 60;
	public static final double rightShooterMax = 60;
	
	public static int rightCounter;
	public static int leftCounter;
	
	public static final int rightCounterMax = 2000;
	public static final int leftCounterMax = 2000;
	
    public CurrentMonitor() {
        rightCounter = 0;
        leftCounter = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftShooterCurrent = RobotMap.pdp.getCurrent(RobotMap.leftShooterPDP);
    	rightShooterCurrent = RobotMap.pdp.getCurrent(RobotMap.rightShooterPDP);
    	
    	if(leftShooterCurrent >= leftShooterMax)
    	{
    		leftCounter++;
    	}
    	else if((leftShooterCurrent <= leftShooterMax) && (RobotMap.leftShooterSad == true))
    	{
    		leftCounter--;
    		if(leftCounter == 0)
    		{
    			RobotMap.leftShooterSad = false;
    		}
    	}
    	else
    	{
    		leftCounter = 0;
    	}
    	if(leftCounter >= leftCounterMax)
    	{
    		RobotMap.leftShooterSad = true;
    	}
    	
    	if(rightShooterCurrent >= rightShooterMax)
    	{
    		rightCounter++;
    	}
    	else if((rightShooterCurrent <= rightShooterMax) && (RobotMap.rightShooterSad == true))
    	{
    		rightCounter--;
    		if(rightCounter == 0)
    		{
    			RobotMap.rightShooterSad = false;
    		}
    	}
    	else
    	{
    		rightCounter = 0;
    	}
    	if(rightCounter >= rightCounterMax)
    	{
    		RobotMap.rightShooterSad = true;
    	}
    	SmartDashboard.putBoolean("Right shooter is sad", RobotMap.rightShooterSad);
		SmartDashboard.putBoolean("Left shooter is sad", RobotMap.leftShooterSad);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
