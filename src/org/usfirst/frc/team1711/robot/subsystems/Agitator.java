package org.usfirst.frc.team1711.robot.subsystems;

import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Agitator extends Subsystem
{
	Talon agitatorMotor;
	
	public Agitator()
	{
		agitatorMotor = RobotMap.agitatorMotor;
	}
	public void agitate(double speed)
	{
		agitatorMotor.set(speed);
	}
	public void stopAgitator()
	{
		agitatorMotor.set(0);
	}
	
	@Override
	protected void initDefaultCommand()
	{
		// TODO Auto-generated method stub
		
	}
	
}