package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.ResetYaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForward extends CommandGroup {
    
    public  DriveForward() {
    	
    	// jump most obstacles, 80% drive for 3 seconds
    	//addSequential(new GyroDrive(.8),3.0);
    	doCommand(.8, 2.5);
    }
    
    public DriveForward(double speed, double time) {
    	doCommand(speed, time);
    }
    
    private void doCommand(double speed, double time) {
    	// if you are using GyroDrive, reset the yaw explicitly
    	addSequential(new ResetYaw(), .25);
    	addSequential(new GyroDrive(speed), time);
    	
    }
}
