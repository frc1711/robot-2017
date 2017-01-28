package org.usfirst.frc.team1711.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	
	CANTalon liftMotor;
	DigitalInput liftSwitch;
	
	public Lift()
	{
		liftMotor = new CANTalon(4); 
		liftSwitch = new DigitalInput(0);
	}
	
	public boolean getLimitSwtich()
		{
		return liftSwitch.get();
		}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void runLift(double speed)
	{
		liftMotor.set(speed);
	}
	
	public void stopLift()
	{
		liftMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

