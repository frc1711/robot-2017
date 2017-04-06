package org.usfirst.frc.team1711.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

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
	public static CANTalon leftAgitatorMotor;
	public static CANTalon rightAgitatorMotor;
	public static CANTalon intakeMotor;
	public static CANTalon liftMotor;
	public static CANTalon leftShooterMotor;
	public static CANTalon rightShooterMotor;
	
	//Joysticks
	public static Joystick driverController;
	
	//Sensors
	public static AnalogGyro gyro;
	public static Encoder leftDriveEncoder;
	public static Encoder rightDriveEncoder;
	
	//PDP
	public static int leftShooterPDP;
	public static int rightShooterPDP;
	public static PowerDistributionPanel pdp;
	
	//Constants
	public static final double pulsesPerInchLeft = 224.5;
	public static final double pulsesPerInchRight = 247.5;
	
	//e-stop
	public static boolean rightShooterSad;
	public static boolean leftShooterSad;
	
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
		
		//PDP
		pdp = new PowerDistributionPanel();
		leftShooterPDP = 2;
		rightShooterPDP = 14;
		
		rightShooterSad = false;
		leftShooterSad = false;
	}
}
