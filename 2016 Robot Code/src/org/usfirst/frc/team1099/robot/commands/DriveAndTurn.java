package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.Drive.AutoDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.TurnAngle;
import org.usfirst.frc.team1099.robot.commands.Intake.AutoEject;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAndTurn extends CommandGroup {
    
    public  DriveAndTurn() {
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

    	addSequential(new GyroDrive(.8), 2); // over the defense
    	addSequential(new GyroDrive(.4), 3); // to the back wall
    	
    	addSequential(new TurnAngle(-75), 2); // turn to the right
    	addSequential(new GyroDrive(.4), 2); // approach the goal
    	addSequential(new AutoEject(), 2);
    }
}
