package org.usfirst.frc.team1711.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

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
//	public static CANTalon agitatorMotor;
	public static Talon agitatorMotor;
	public static CANTalon intakeMotor;
	public static CANTalon liftMotor;
	public static CANTalon shooterMotor;
	
	//Joysticks
	public static Joystick driverController;
	
	//Sensors
	public static AnalogGyro gyro;
	public static DigitalInput liftSwitch;
//	public static Encoder shooterEncoder;
	
	public static void init()
	{
		driverController = new Joystick(0);
		
		//CAN bus assignments
		frontLeftDriveCANTalon = new CANTalon(1);
		frontRightDriveCANTalon = new CANTalon(3);
		rearLeftDriveCANTalon = new CANTalon(0);
		rearRightDriveCANTalon = new CANTalon(2);
		liftMotor = new CANTalon(4);
		
		//PWM port assignments
//		agitatorMotor = new CANTalon(5);
		agitatorMotor = new Talon(5);
		intakeMotor = new CANTalon(6);
		shooterMotor = new CANTalon(7);
		
		//Analog port assignments
		gyro = new AnalogGyro(0);
		
		//Digital port assignments
		liftSwitch = new DigitalInput(0);
//		shooterEncoder = new Encoder(-1,-1);
	}
}
