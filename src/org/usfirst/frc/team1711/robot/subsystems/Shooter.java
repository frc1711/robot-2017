package org.usfirst.frc.team1711.robot.subsystems;
import org.usfirst.frc.team1711.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends PIDSubsystem
{	
	//create shooter motor object
	CANTalon shooterMotor = RobotMap.shooterMotor;
//	Encoder shooterEncoder = RobotMap.shooterEncoder;
	static Preferences prefs;
	public static double p = prefs.getDouble("P: ",0.0);
	public static double i = prefs.getDouble("I: ",1.0);
	public static double d = prefs.getDouble("D: ",0.0);
	public Shooter()
	{
		super("Shooter", p, i, d);
		//construct that shooter
		//setAbsoluteTolerance(.2);
		getPIDController().setContinuous(false);
		
	}
	protected double returnPIDInput()
	{
		return  5;//shooterEncoder.getRate();
	} 
	protected void usePIDOutput(double output)
	{
		shooterMotor.pidWrite(output);
	}
	public void dashBoardControl(){
		SmartDashboard.putNumber("P: ",p);
		SmartDashboard.putNumber("I: ",i);
		SmartDashboard.putNumber("D: ",d);
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