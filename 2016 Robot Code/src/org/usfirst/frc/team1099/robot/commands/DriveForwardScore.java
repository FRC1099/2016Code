package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.TurnAngle;
import org.usfirst.frc.team1099.robot.commands.Intake.AutoEject;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardScore extends CommandGroup {
    public static final int RIGHT = 0;
    public static final int LEFT = 1;
    public  DriveForwardScore(int side) {
    	int adjust = 10; //10 degrees to the right
    	int turntogoal = -90;
    	if (side == RIGHT) {
    		adjust *= -1;
    		turntogoal *= -1;
    	}
    	addSequential(new GyroDrive(.8), 2.0);
    	addSequential(new TurnAngle(adjust), 2.0);
    	addSequential(new GyroDrive(.4), 2.0);
    	addSequential(new GyroDrive(-.3), .5);
    	
    	addSequential(new TurnAngle(turntogoal), 4.0);
    	addSequential(new GyroDrive(.4), 2.0);
    	addSequential(new AutoEject(), 2.0);
    }
}
