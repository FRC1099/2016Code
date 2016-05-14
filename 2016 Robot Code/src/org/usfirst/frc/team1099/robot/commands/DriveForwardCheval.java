package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.DefenseArm.DownDefenseArm;
import org.usfirst.frc.team1099.robot.commands.DefenseArm.UpDefenseArm;
import org.usfirst.frc.team1099.robot.commands.Drive.AutoDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.ResetYaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardCheval extends CommandGroup {
    
    public  DriveForwardCheval() {
        //#omgrobots
    	
    	//addSequential(new ResetYaw(), .25);
    	//addSequential(new GyroDrive(.35),0.9);
    	//addSequential(new DownDefenseArm(), 2.5);
    	//addSequential(new GyroDrive(1.0),3.0);
    	
    	addSequential(new ResetYaw(), .25);
    	addSequential(new GyroDrive(.4), .9);
    	//addSequential(new DoNothing(), 3.0);
    	addSequential(new AutoDrive(0.0), 3.0);
    	addSequential(new DownDefenseArm(), 2);
    	addSequential(new GyroDrive(1.0), 3.0);
    }
}
