package org.usfirst.frc.team1711.robot.networking;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * PiNetworkTable controls the communication protocol between the Raspberry Pi and the RoboRIO by dealing with communication through
 * the network table. This class operates on the RoboRIO side.
 * @author Abigail
 *
 */
public class PiNetworkTable
{
	NetworkTable table;

	public PiNetworkTable()
	{
		table = NetworkTable.getTable("Raspberry Pi");
	}
	
	public void systemTest()
	{
		double number = System.currentTimeMillis();
		table.putNumber("datatable", number);
	}
	
	public double getAngleDifference()
	{
		double angleDifference = table.getNumber("angle difference", 0);
		return angleDifference;
	}
	
	public double getDistance()
	{
		double distance = table.getNumber("distance from target", 0);
		return distance;
	}
	
	public void setCamera(int chosenCamera)
	{
		table.putNumber("Camera", chosenCamera);
	}
}