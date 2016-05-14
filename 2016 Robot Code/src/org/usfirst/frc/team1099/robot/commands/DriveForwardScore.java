package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.DefenseArm.UpDefenseArm;
import org.usfirst.frc.team1099.robot.commands.Drive.AutoDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.ResetYaw;
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
    	// int adjust = 10; //10 degrees to the right
    	int turntogoal = -45;
    	if (side == RIGHT) {
    		// adjust *= -1;
    		turntogoal *= -1;
    	}
    	
    	// to the wall
    	addSequential(new ResetYaw());
    	addSequential(new GyroDrive(.8), 1.5);
    	addSequential(new TurnAngle(0), 2.0);
    	addSequential(new UpDefenseArm(), 1.0);
    	addSequential(new TurnAngle(0), 2.0);
    	addSequential(new GyroDrive(.3), 4.0);
    	
    	// reposition
    	addSequential(new AutoDrive(-.3), 0.6);
    	addSequential(new TurnAngle(turntogoal), 3.0);
    	addSequential(new UpDefenseArm(), 1.0);
    	
    	
    	//addSequential(new ResetYaw());
    	addSequential(new AutoDrive(.4), 3.0);
    	addSequential(new AutoEject(), 2.0);
    }
}
