package org.usfirst.frc.team1711.robot.subsystems;

import org.usfirst.frc.team1711.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
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
	
	Encoder leftDriveEncoder;
	Encoder rightDriveEncoder;
	
	RobotDrive drive;
	
	AnalogGyro gyro;
	
	//gero is the gyro zero
	//thanks jack for the weird coding terms
	private double gero;
	
	public DriveSystem()
	{
		leftFrontDrive = RobotMap.frontLeftDriveCANTalon;
		rightFrontDrive = RobotMap.frontRightDriveCANTalon;
		leftRearDrive = RobotMap.rearLeftDriveCANTalon;
		rightRearDrive = RobotMap.rearRightDriveCANTalon;
		
//		leftDriveEncoder = RobotMap.leftDriveEncoder;
//		rightDriveEncoder = RobotMap.rightDriveEncoder;
		
		//set encoder stuff here
		
		drive = new RobotDrive(leftFrontDrive, leftRearDrive, rightFrontDrive, rightRearDrive);
		
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
	
	public void driveForward(double speed)
	{
		leftFrontDrive.set(speed);
		leftRearDrive.set(speed);
		rightFrontDrive.set(speed);
		rightRearDrive.set(speed);
	}
	
	public void turnLeft(double speed)
	{
		leftFrontDrive.set(-speed);
		leftRearDrive.set(-speed);
		rightFrontDrive.set(speed);
		rightRearDrive.set(speed);
	}
	
	public void turnRight(double speed)
	{
		leftFrontDrive.set(speed);
		leftRearDrive.set(speed);
		rightFrontDrive.set(-speed);
		rightRearDrive.set(-speed);
	}
	
	public void resetGyro()
	{
		gero = gyro.getAngle();
	}
	
	public double getGyroRate()
	{
		return gyro.getRate();
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