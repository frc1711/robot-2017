package org.usfirst.frc.team1711.robot.subsystems;

import org.usfirst.frc.team1711.robot.RobotMap;

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
		liftMotor = RobotMap.liftMotor;
	}
	
	public boolean getLimitSwitch()
	{
		return liftSwitch.get();
	}
	
	public void runLift(double speed)
	{
		liftMotor.set(speed);
	}
	
	public void stopLift()
	{
		liftMotor.set(0);
	}
	
    public void initDefaultCommand() {
    }
}

