package org.usfirst.frc.team1711.robot.subsystems;

import org.usfirst.frc.team1711.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem
{
	//Motor controllers
	CANTalon frontRightDrive;
	CANTalon frontLeftDrive;
	CANTalon rearRightDrive;
	CANTalon rearLeftDrive;
	
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
		
		frontRightDrive = new CANTalon(1);
		frontLeftDrive = new CANTalon(0);
		
		frontLeftDrive.reverseOutput(true);
		rearRightDrive.reverseOutput(true);
		
		drive = new RobotDrive(frontLeftDrive, rearLeftDrive, frontRightDrive, rearRightDrive);
		
		gyro = RobotMap.gyro;
	}
	
	public void stopMotors()
	{
		frontRightDrive.set(0);
		frontLeftDrive.set(0);
		rearRightDrive.set(0);
		rearLeftDrive.set(0);
	}
	
	public void cartesianDrive(double x, double y, double rotation, double gyroAngle)
	{
		drive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}
	
	public void polarDrive(double magnitude, double direction, double rotation)
	{
		drive.mecanumDrive_Polar(magnitude, direction, rotation);
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