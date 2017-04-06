package org.usfirst.frc.team1711.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends PIDSubsystem
{	
	CANTalon shooterMotor;
	static Preferences prefs;
	public static double p = 0.0; 
	public static double i = 1.0; 
	public static double d = 0.0;  
	
	public Shooter(CANTalon shooterMotor)
	{
		super("Shooter", Preferences.getInstance().getDouble("P", 0.0), Preferences.getInstance().getDouble("I", 0.0), Preferences.getInstance().getDouble("D", 0.0));
		this.shooterMotor = shooterMotor;
		//construct that shooter
		setAbsoluteTolerance(.2);
		getPIDController().setContinuous(false);
		
	}
	protected double returnPIDInput()
	{
		return 0;
	} 
	protected void usePIDOutput(double output)
	{
		shooterMotor.pidWrite(output);
	}
	public void getUSB()
	{
		
	}
	public void dashBoardControl()
	{
		p = Preferences.getInstance().getDouble("P",0.0);
		i = Preferences.getInstance().getDouble("I",1.0);
		d = Preferences.getInstance().getDouble("D",0.0);
		SmartDashboard.putNumber("P",getPIDController().getP());
		SmartDashboard.putNumber("I",getPIDController().getI());
		SmartDashboard.putNumber("D",getPIDController().getD());
		getPIDController().setPID(p,i,d);
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