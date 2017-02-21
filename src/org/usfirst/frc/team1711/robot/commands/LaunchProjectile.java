package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.MagicNumbers;
import org.usfirst.frc.team1711.robot.OI;
import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class controls shooting for both shooters.
 * @author Joe
 *
 */
public class LaunchProjectile extends Command
{
	 
	/**
	 * Declares the subsystem dependencies for this command
	 * This command requires both the left and right shooter
	 */
	public LaunchProjectile()
	{
		requires(Robot.leftShooter);
		requires(Robot.rightShooter);
	}
	
	protected void initialize()
	{
	}
	
	/**
	 * Runs both the left and right shooter at variable power levels determined by the trigger axes on the Xbox controller
	 */
	protected void execute()
	{
			//shoot real quick
		if(RobotMap.leftShooterSad == false)
			Robot.leftShooter.shoot((RobotMap.driverController.getRawAxis(3)));
		else
			Robot.leftShooter.shoot(0);
		if(RobotMap.rightShooterSad == false)
			Robot.rightShooter.shoot(-1 * (RobotMap.driverController.getRawAxis(2)));
		else
			Robot.leftShooter.shoot(0);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Sets the power for both shooters to zero
	 */
	protected void end()
	{
		Robot.leftShooter.shoot(0);
		Robot.rightShooter.shoot(0);
	}

	/**
	 * Sets the power for both shooters to zero
	 */
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.leftShooter.shoot(0);
		Robot.rightShooter.shoot(0);
	}
	
}