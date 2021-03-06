package org.usfirst.frc.team1711.robot.subsystems;

import org.usfirst.frc.team1711.robot.RobotMap;
import org.usfirst.frc.team1711.robot.commands.drive.RawJoystickDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This class defines the drive system object
 * @author Abigail
 *
 */
public class DriveSystem extends Subsystem
{
	//Motor controllers
	CANTalon leftFrontDrive;
	CANTalon rightFrontDrive;
	CANTalon leftRearDrive;
	CANTalon rightRearDrive;
	
	private double driveLeftEncoder = 0;
	private double driveRightEncoder = 0;
	
	static final double BIAS_CORRECTION = 1;
	
	public RobotDrive drive;
	
	AnalogGyro gyro;
	
	//gero is the gyro zero
	//thanks sam for the weird coding terms
	private double gero;
	
	boolean inSetPointMode = false;
	double setPoint;
	
	/**
	 * Creates a drive system with four CANTalon objects
	 */
	public DriveSystem()
	{
		leftFrontDrive = RobotMap.frontLeftDriveCANTalon;
		leftFrontDrive.setInverted(true);
		rightFrontDrive = RobotMap.frontRightDriveCANTalon;
		rightFrontDrive.setInverted(true);
		leftRearDrive = RobotMap.rearLeftDriveCANTalon;
		leftRearDrive.setInverted(true);
		rightRearDrive = RobotMap.rearRightDriveCANTalon;
		rightRearDrive.setInverted(true);
		
		leftRearDrive.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		rightRearDrive.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
		drive = new RobotDrive(leftFrontDrive, leftRearDrive, rightFrontDrive, rightRearDrive);
		
		gyro = RobotMap.gyro;
		
		drive.setSafetyEnabled(false);
	}
	
	/**
	 * Sets the power of all four drive motors to zero
	 */
	public void stopMotors()
	{
		leftFrontDrive.set(0);
		rightFrontDrive.set(0);
		leftRearDrive.set(0);
		rightRearDrive.set(0);
	}
	
	/**
	 * Controls basic arcade driving, using WPIlib methods
	 * @param stick
	 */
	public void arcadeDrive(Joystick stick)
	{
		drive.arcadeDrive(stick);
	}
	
	public void backwardsArcade()
	{
		drive.arcadeDrive(-1 *(RobotMap.driverController.getRawAxis(1)), (RobotMap.driverController.getRawAxis(0)));
	}
	
	public void macroDrive()
	{
		drive.arcadeDrive(0.5 * (RobotMap.driverController.getRawAxis(1)), 0.5 * (RobotMap.driverController.getRawAxis(0)));
	}
	
	/**
	 * Drives the robot forward at the specified speed
	 * @param speed
	 */
	public void driveForward(double speed)
	{
		leftFrontDrive.set(-speed *(BIAS_CORRECTION));
		leftRearDrive.set(-speed * (BIAS_CORRECTION));
		rightFrontDrive.set(speed);
		rightRearDrive.set(speed);
	}
	
	/**
	 * Turns the robot left at the specified speed
	 * @param speed
	 */
	public void turnLeft(double speed)
	{
		leftFrontDrive.set(speed * (BIAS_CORRECTION));
		leftRearDrive.set(speed * (BIAS_CORRECTION));
		rightFrontDrive.set(speed);
		rightRearDrive.set(speed);
	}
	
	/**
	 * Turns the robot right at the specified speed
	 * @param speed
	 */
	public void turnRight(double speed)
	{
		leftFrontDrive.set(-speed * (BIAS_CORRECTION));
		leftRearDrive.set(-speed * (BIAS_CORRECTION));
		rightFrontDrive.set(-speed);
		rightRearDrive.set(-speed);
	}
	
	/**
	 * Sets the current gyro heading to be the zero point
	 */
	public void resetGyro()
	{
		gero = gyro.getAngle();
	}
	
	/**
	 * Gets the current rate of the gyro
	 * @return The rate, in degrees per second
	 */
	public double getGyroRate()
	{
		return gyro.getRate();
	}
	
	/**
	 * Gets the relative gyro angle
	 * @return The current gyro angle minus the zero angle set at the last reset
	 */
	public double getGyroAngle()
	{
		return gyro.getAngle() - gero;
	}
	
	/**
	 * Gets the absolute gyro angle
	 * @return The absolute angle of the gyro, in degrees
	 */
	public double getAbsGyroAngle()
	{
		//does not account for zeroing
		return gyro.getAngle();
	}
	
	/**
	 * Gets the current position of the drive encoder
	 * @return The current position of the drive encoder
	 */
	public double getLeftDriveEncoder()
	{
		return (-1 * (leftRearDrive.getEncPosition()) + driveLeftEncoder);
	}
	
	public double getRightDriveEncoder()
	{
		return (rightRearDrive.getEncPosition() - driveRightEncoder);
	}
	
	public double getAbsoluteLeftEncoder()
	{
		return (-1 * (leftRearDrive.getEncPosition()));
	}
	
	public double getAbsoluteRightEncoder()
	{
		return rightRearDrive.getEncPosition();
	}
	
	public double getEncoders()
	{
		double average = (getRightDriveEncoder() + getLeftDriveEncoder()) / 2;
		return average;
	}
	
	public void enablePositionMode()
	{
		leftRearDrive.changeControlMode(TalonControlMode.Position);
		leftFrontDrive.changeControlMode(TalonControlMode.Follower);
		rightFrontDrive.changeControlMode(TalonControlMode.Follower);
		rightRearDrive.changeControlMode(TalonControlMode.Position);
		
		leftRearDrive.set(0);
		leftFrontDrive.set(6);
		rightFrontDrive.set(6);
		rightRearDrive.set(0);
		
		inSetPointMode = true;
	}
	
	public void disablePositionMode()
	{
		leftRearDrive.changeControlMode(TalonControlMode.Speed);
		leftFrontDrive.changeControlMode(TalonControlMode.Speed);
		rightFrontDrive.changeControlMode(TalonControlMode.Speed);
		rightRearDrive.changeControlMode(TalonControlMode.Speed);
		
		leftRearDrive.set(0);
		leftFrontDrive.set(0);
		rightRearDrive.set(0);
		rightFrontDrive.set(0);
		
		leftRearDrive.reverseOutput(false);
		leftFrontDrive.reverseOutput(false);
		
		inSetPointMode = false;
	}
	
	public void setSetpoint(double setPoint)
	{
		//this.setPoint = setPoint / RobotMap.distancePerPulse;
	}
	
	public void goToSetpoint()
	{
		if(inSetPointMode == true)
			leftRearDrive.set(this.setPoint);
	}
	
/*	public boolean isAtSetPoint()
	{
		if(getDriveEncoder() >= setPoint)
			return true;
		else
			return false;
	} */
	
	public void zeroEncoders()
	{
		driveLeftEncoder = leftRearDrive.getEncPosition();
		driveRightEncoder = rightRearDrive.getEncPosition();
	}
	
	public double getEncoderRate()
	{
		return leftRearDrive.getEncVelocity();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new RawJoystickDrive());
		
	}
	
}