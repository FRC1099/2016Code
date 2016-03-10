package org.usfirst.frc.team1099.robot.commands;
import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveInSquare extends CommandGroup {
    
    public  DriveInSquare() {
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

    	/*
    	addSequential(new GyroDrive(.8), 2); // over the defense
    	addSequential(new GyroDrive(.4), 3); // to the back wall
    	
    	addSequential(new TurnAngle(-75), 2); // turn to the right
    	addSequential(new GyroDrive(.4), 2); // approach the goal
    	addSequential(new AutoEject(), 2);
    	*/
    	
    	for(int i=0; i<4; i++) {
    		addSequential(new GyroDrive(.3), 1); // over forward
    		addSequential(new TurnAngle(90), 4); // turn 
    	}
    }
}
