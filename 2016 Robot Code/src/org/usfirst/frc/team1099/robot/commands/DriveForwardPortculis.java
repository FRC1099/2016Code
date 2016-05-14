package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.DefenseArm.DownDefenseArm;
import org.usfirst.frc.team1099.robot.commands.DefenseArm.UpDefenseArm;
import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.ResetYaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardPortculis extends CommandGroup {
    
    public  DriveForwardPortculis() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new ResetYaw(), .25);
    	addSequential(new GyroDrive(.25),1.5);
    	addSequential(new DownDefenseArm(), 1.0);
    	addSequential(new GyroDrive(.25), 0.5);
    	addParallel(new UpDefenseArm(), 1.5);
    	addSequential(new GyroDrive(.2),1.5);
    	addSequential(new GyroDrive(1.0),2.0);
    }
}
