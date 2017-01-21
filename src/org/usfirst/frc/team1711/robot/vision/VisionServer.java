package org.usfirst.frc.team1711.robot.vision;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class VisionServer
{
	UsbCamera camera;
	CvSink cvSink;
	CvSource outputStream;
	Mat source;
	Mat output;
	VisionThread visionThread;
	GripPipeline pipeline;
	NetworkTable table;
	
	public VisionServer()
	{
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(640, 480);
		cvSink = CameraServer.getInstance().getVideo();
		outputStream = CameraServer.getInstance().putVideo("Blur", 640,
		480);
		source = new Mat();
		output = new Mat();
		visionThread = new VisionThread(camera, pipeline,new VisionRunner.Listener<GripPipeline>() {

			@Override
			public void copyPipelineOutputs(GripPipeline pipeline) {
				// TODO Auto-generated method stub
				
			}
		});
		visionThread.start();
		table = NetworkTable.getTable("GRIP/myContoursReport");
	}
	
	public void visionFeed()
	{
		cvSink.grabFrame(source);
		Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
		outputStream.putFrame(output);
	}
	
	public void processVision()
	{
		
	}
}