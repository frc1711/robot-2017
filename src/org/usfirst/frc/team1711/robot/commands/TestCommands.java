package org.usfirst.frc.team1711.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestCommands extends CommandGroup
{
	public TestCommands()
	{
		addParallel(new DriveJoystickTest());
	}
}