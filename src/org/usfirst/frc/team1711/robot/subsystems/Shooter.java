package org.usfirst.frc.team1711.robot.subsystems;
import org.usfirst.frc.team1711.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends PIDSubsystem
{	
	//create shooter motor object
	CANTalon shooterMotor = RobotMap.shooterMotor;
	Encoder shooterEncoder = RobotMap.shooterEncoder;
	public Shooter()
	{	
		super("Shooter", 0.0, 1.0, 0.0);
		//construct that shooter
		//setAbsoluteTolerance(.2);
		getPIDController().setContinuous(false);
		
	}
	protected double returnPIDInput()
	{
		return shooterEncoder.getRate();
	}
	protected void usePIDOutput(double output)
	{
		shooterMotor.pidWrite(output);
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