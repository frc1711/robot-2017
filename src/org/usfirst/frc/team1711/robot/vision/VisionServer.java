package org.usfirst.frc.team1711.robot.vision;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class VisionServer
{
	UsbCamera camera;
	CvSink cvSink;
	CvSource outputStream;
	Mat source;
	Mat output;
	
	public VisionServer()
	{
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(640, 480);
		cvSink = CameraServer.getInstance().getVideo();
		outputStream = CameraServer.getInstance().putVideo("Blur", 640,
		480);
		source = new Mat();
		output = new Mat();
	}
	
	public void visionFeed()
	{
		cvSink.grabFrame(source);
		Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
		outputStream.putFrame(output);
	}
}