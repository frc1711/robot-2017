package org.usfirst.frc.team1711.robot.commands;

import org.usfirst.frc.team1711.robot.MagicNumbers;
import org.usfirst.frc.team1711.robot.OI;
import org.usfirst.frc.team1711.robot.Robot;
import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class LaunchProjectile extends Command
{
	 
	public LaunchProjectile()
	{
		requires(Robot.leftShooter);
		requires(Robot.rightShooter);
	}
	
	protected void initialize()
	{
	}
	
	protected void execute()
	{
			//shoot real quick
			Robot.leftShooter.shoot(-1 * (RobotMap.driverController.getRawAxis(3)));
			Robot.rightShooter.shoot(-1 * (RobotMap.driverController.getRawAxis(2)));
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end()
	{
		Robot.leftShooter.shoot(0);
		Robot.rightShooter.shoot(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.leftShooter.shoot(0);
		Robot.rightShooter.shoot(0);
	}
	
}