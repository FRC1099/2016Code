package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.Drive.AutoDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.Grabber.Grab;
import org.usfirst.frc.team1099.robot.commands.Grabber.Un_Grab;
import org.usfirst.frc.team1099.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveLowBar extends CommandGroup {
    
    public  DriveLowBar() {
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
    	
    	//double speed = SmartDashboard.getNumber("bu speed",  .25);
    	addSequential(new Un_Grab(), .5); 
    	addSequential(new AutoDrive(-0.25), 10.0);
    	addSequential(new Grab(), .5);
    	addSequential(new AutoDrive(.2), 0.5);
    }
}
