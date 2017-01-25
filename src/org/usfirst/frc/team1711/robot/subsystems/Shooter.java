package org.usfirst.frc.team1711.robot.subsystems;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem
{	
	//cre4ate shooter motor object
	Talon shooterMotor;
	public Shooter()
	{
		shooterMotor = new Talon(1);
	}
	public void shoot(double speed)
	{
		shooterMotor.set(speed);
	}
	public void stopShooter()
	{
		shooterMotor.set(0);
	}
	
	@Override
	protected void initDefaultCommand()
	{
		// TODO Auto-generated method stub
		
	}
	
}