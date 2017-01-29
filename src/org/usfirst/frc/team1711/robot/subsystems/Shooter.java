package org.usfirst.frc.team1711.robot.subsystems;
import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem
{	
	//create shooter motor object
	Talon shooterMotor;
	
	public Shooter()
	{	
		//construct that shooter
		shooterMotor = RobotMap.shooterMotor;
	}
	public void shoot(double speed)
	{
		//shoot
		shooterMotor.set(speed);
	}
	public void stopShooter()
	{
		//stop shooter
		shooterMotor.set(0);
	}
	
	@Override
	protected void initDefaultCommand()
	{
		// TODO Auto-generated method stub
		
	}
	
}