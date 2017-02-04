package org.usfirst.frc.team1711.robot.subsystems;

import org.usfirst.frc.team1711.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	CANTalon intakeMotor;
	
	public Intake()
	{
		intakeMotor = RobotMap.intakeMotor;
	}
	
	
	public void absorb(double speed)
	{
		intakeMotor.set(speed);
	}
	
	public void stopIntake()
	{
		intakeMotor.set(0);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

