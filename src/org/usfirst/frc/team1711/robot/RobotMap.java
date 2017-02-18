package org.usfirst.frc.team1711.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SerialPort;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Motor control lers
	public static CANTalon frontLeftDriveCANTalon;
	public static CANTalon frontRightDriveCANTalon;
	public static CANTalon rearLeftDriveCANTalon;
	public static CANTalon rearRightDriveCANTalon;
	public static CANTalon leftAgitatorMotor;
	public static CANTalon rightAgitatorMotor;
	public static CANTalon intakeMotor;
	public static CANTalon liftMotor;
	public static CANTalon leftShooterMotor;
	public static CANTalon rightShooterMotor;
	
	//Joysticks
	public static Joystick driverController;
	
	//Serial Ports
	public static SerialPort encoderUSB;
	
	//Sensors
	public static AnalogGyro gyro;
	public static DigitalInput liftSwitch;
	public static Encoder leftDriveEncoder;
	public static Encoder rightDriveEncoder;
	public static Encoder shooterEncoder;
	
	public static void init()
	{
		driverController = new Joystick(0);
		
		//CAN bus assignments
		frontLeftDriveCANTalon = new CANTalon(7);
		frontRightDriveCANTalon = new CANTalon(0);
		rearLeftDriveCANTalon = new CANTalon(6);
		rearRightDriveCANTalon = new CANTalon(1);
		liftMotor = new CANTalon(4);
		
		//PWM port assignments
		leftAgitatorMotor = new CANTalon(2);
		rightAgitatorMotor = new CANTalon(9);
		intakeMotor = new CANTalon(3);
		leftShooterMotor = new CANTalon(5);
		rightShooterMotor = new CANTalon(8);
		
		//Analog port assignments
		gyro = new AnalogGyro(0);
		
		//Digital port assignments
		liftSwitch = new DigitalInput(0);
		shooterEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
//		leftDriveEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
//		rightDriveEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	}
}
