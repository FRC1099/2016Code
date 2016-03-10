package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForward extends CommandGroup {
    
    public  DriveForward() {
    	
    	// jump most obstacles, 80% drive for 2 seconds
    	addSequential(new GyroDrive(.8),2.0);    	
    }
}
