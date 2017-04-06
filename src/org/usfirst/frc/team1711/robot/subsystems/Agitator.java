package org.usfirst.frc.team1711.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This class defines the agitator object
 *
 */
public class Agitator extends Subsystem
{
	CANTalon agitatorMotor;
	
	/**
	 * Takes the given CANTalon, and creates an agitator object linked to that CANTalon
	 * @param agitatorMotor
	 */
	public Agitator(CANTalon agitatorMotor)
	{
		this.agitatorMotor = agitatorMotor;
	}
	
	/**
	 * Spins the agitator at the desired speed
	 * @param speed
	 */
	public void agitate(double speed)
	{
		agitatorMotor.set(speed);
	}
	
	/**
	 * Sets the power of the agitator motor to zero
	 */
	public void stopAgitator()
	{
		agitatorMotor.set(0);
	}
	
	@Override
	protected void initDefaultCommand()
	{
		// TODO Auto-generated method stub
		
	}
	
}