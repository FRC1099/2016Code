package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.Drive.AutoDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Spin extends CommandGroup {

	public Spin() {
		
		addSequential(new AutoDrive(.5, -.5), 1.0);
	}
}
