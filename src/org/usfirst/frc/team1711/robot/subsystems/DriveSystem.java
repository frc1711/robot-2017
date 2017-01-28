package org.usfirst.frc.team1711.robot.subsystems;

import org.usfirst.frc.team1711.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem
{
	//Motor controllers
	CANTalon leftFrontDrive;
	CANTalon rightFrontDrive;
	CANTalon leftRearDrive;
	CANTalon rightRearDrive;
	
	RobotDrive drive;
	
	AnalogGyro gyro;
	
	//gero is the gyro zero
	//thanks jack for the weird coding terms
	private double gero;
	
	public DriveSystem()
	{
		leftFrontDrive = new CANTalon(0);
		rightFrontDrive = new CANTalon(1);
		leftRearDrive = new CANTalon(2);
		rightRearDrive = new CANTalon(3);
		
		drive = new RobotDrive(leftFrontDrive, rightFrontDrive, leftRearDrive, rightRearDrive);
		
		gyro = RobotMap.gyro;
	}
	
	public void stopMotors()
	{
		leftFrontDrive.set(0);
		rightFrontDrive.set(0);
		leftRearDrive.set(0);
		rightRearDrive.set(0);
	}
	
	public void arcadeDrive(Joystick stick)
	{
		drive.arcadeDrive(stick);
	}
	
	public void resetGyro()
	{
		gero = gyro.getAngle();
	}
	
	public double getGyroAngle()
	{
		return gyro.getAngle() - gero;
	}
	
	public double getAbsGyroAngle()
	{
		//does not account for zeroing
		return gyro.getAngle();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}