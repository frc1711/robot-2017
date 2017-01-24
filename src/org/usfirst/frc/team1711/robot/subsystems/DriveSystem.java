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
	CANTalon rightDrive;
	CANTalon leftDrive;
	
	RobotDrive drive;
	
	AnalogGyro gyro;
	
	//gero is the gyro zero
	//thanks jack for the weird coding terms
	private double gero;
	
	public DriveSystem()
	{
//		frontRightDrive = RobotMap.frontRightDriveCANTalon;
	//	frontLeftDrive = RobotMap.frontLeftDriveCANTalon;
	//	rearRightDrive = RobotMap.rearRightDriveCANTalon;
	//	rearLeftDrive = RobotMap.rearLeftDriveCANTalon;
		
		rightDrive = new CANTalon(1);
		leftDrive = new CANTalon(0);
		
//		leftDrive.reverseOutput(true);
//		rightDrive.reverseOutput(true);
		
		drive = new RobotDrive(leftDrive, rightDrive);
		
		gyro = RobotMap.gyro;
	}
	
	public void stopMotors()
	{
		rightDrive.set(0);
		leftDrive.set(0);
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