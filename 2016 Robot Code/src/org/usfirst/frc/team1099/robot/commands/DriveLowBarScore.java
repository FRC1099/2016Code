package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.TurnAngle;
import org.usfirst.frc.team1099.robot.commands.Grabber.Grab;
import org.usfirst.frc.team1099.robot.commands.Grabber.Un_Grab;
import org.usfirst.frc.team1099.robot.commands.Intake.AutoEject;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveLowBarScore extends CommandGroup {
    
    public  DriveLowBarScore() {
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
    	addSequential(new DriveLowBar(), 10);
    	addSequential(new TurnAngle(-100), 4);
    	addSequential(new GyroDrive(.4), 2.0);
    	addSequential(new AutoEject(), 2.0);
    }
}
