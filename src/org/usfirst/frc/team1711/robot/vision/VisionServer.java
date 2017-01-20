package org.usfirst.frc.team1711.robot.vision;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class VisionServer
{
	CameraServer server;
	UsbCamera processorCam;
	
	public VisionServer()
	{
		processorCam = new UsbCamera("processorCam", 0);
		server.getInstance().startAutomaticCapture(processorCam);
		System.out.println("hello world!!");
	}
	
	public void visionFeed()
	{
		
	}
}