package org.usfirst.frc.team1711.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Motor controllers
	public static CANTalon frontLeftDriveCANTalon;
	public static CANTalon frontRightDriveCANTalon;
	public static CANTalon rearLeftDriveCANTalon;
	public static CANTalon rearRightDriveCANTalon;
	
	//Joysticks
	public static Joystick driverController;
	
	//Sensors
	public static AnalogGyro gyro;
	
	public static void init()
	{
		driverController = new Joystick(0);
		//these are not the right magic numbers
		//I need to figure out the right magic numbers
		frontLeftDriveCANTalon = new CANTalon(0);
		frontRightDriveCANTalon = new CANTalon(1);
		rearLeftDriveCANTalon = new CANTalon(2);
		rearRightDriveCANTalon = new CANTalon(3);
		
		//this is the analog port being used
		gyro = new AnalogGyro(0);
	}
}
