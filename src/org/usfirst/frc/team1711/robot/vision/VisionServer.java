package org.usfirst.frc.team1711.robot.vision;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class VisionServer
{
	CameraServer server;
	UsbCamera processorCam;
	
	public VisionServer()
	{
		processorCam = new UsbCamera("processorCam", 1);
		server.getInstance().startAutomaticCapture(processorCam);
	}
	
	public void visionFeed()
	{
		
	}
}