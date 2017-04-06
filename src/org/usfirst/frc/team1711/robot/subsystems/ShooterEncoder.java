package org.usfirst.frc.team1711.robot.subsystems;
import org.usfirst.frc.team1711.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Interfaces with the Arduino based encoding circuit that
 * connects via MXP serial port (we cannot use on-board RS-232
 * as the voltages are wrong)
 * 
 * The Arduino is connected at a baud rate of 57600 bps and 
 * sends a string packet of "<Encoder 1 RPM>:<Encoder 2 RPM>".
 * 
 * This class reads and breaks that message apart then parses
 * into integer values for use by the Shooter subsystem.
 * 
 * @author tmcginty
 */
public class ShooterEncoder extends Thread {
	private boolean running=false;

	private int encoder1=0;
	public int getEncoder1() {
		return encoder1;
	}

	private int encoder2=0;
	public int getEncoder2() {
		return encoder2;
	}

	/**
	 * Reads from the serial port and processes
	 * string response if any. See header for
	 * response format expected
	 */
	public void run()
	{
/*		RobotMap.serialPort.reset();
		while(running) {
			// read from the serial port
			try 
			{
				String ln=new String();
				try
				{
					ln=RobotMap.serialPort.readString();
				}
				catch (Exception e)
				{
					
				}
				if(ln.length()>2)
				{
					// remove line termination
					ln=ln.replace("\r", "");
					ln=ln.replace("\n", "");
					// break string into parts "RPM1:RPM2"
					String parts[]=ln.split(":");
					try 
					{
						encoder1=Integer.parseInt(parts[0]);
					}
					catch(Exception e1) 
					{ // leave last value}
					}
					try 
					{
						encoder2=Integer.parseInt(parts[1]);
					}
					catch(Exception e2) 
					{ // leave last value 
					}
					try
					{
						sleep(1000);
					}
					catch(InterruptedException ie) 
					{
					}
					
// 					System.out.println("Encoder 1=" + encoder1 + "  Encoder 2=" + encoder2);
				}
			} 
			catch(Exception e)
			{
				// port not available, stop thread
				running=false;
			} 
		} */
	}

	public ShooterEncoder()
	{
		super("ShooterEncoder");

		// start the reader thread
		running=true;
		start();
	}
	
	protected void finalize()
	{
		running=false;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}