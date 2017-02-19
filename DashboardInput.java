import org.usfirst.frc.team1711.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DashboardInput extends Command
{
	public DashboardInput()
	{
		
	}
	
	protected void initialize()
	{
		
	}
	
	protected void execute()
	{
		//these should be shown on graphs or dials
		SmartDashboard.putNumber("Left shooter current draw", RobotMap.pdp.getCurrent(RobotMap.leftShooterPDP));
		SmartDashboard.putNumber("Right shooter current draw", RobotMap.pdp.getCurrent(RobotMap.rightShooterPDP));
		SmartDashboard.putNumber("PDP Temperature", RobotMap.pdp.getTemperature());
		//SmartDashboard.getNumber(); add something like this with an RPi counter
	}
	
	protected boolean isFinished()
	{
		
	}
	
	protected void end()
	{
		
	}
	
	protected void interrupted()
	{
		
	}
}