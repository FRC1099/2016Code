package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.Robot;
import org.usfirst.frc.team1099.robot.commands.LiftArm.StartLiftArm;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftArm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor liftmotor = new Victor(5);
	
	public LiftArm(){
	}
	
	public void liftArm() {
		if(Robot.oi.getLiftArm() > 0.05 || Robot.oi.getLiftArm() < -0.05) {
			liftmotor.set(Robot.oi.getLiftArm());
		} else {
			liftmotor.set(0);
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StartLiftArm());
    }
}

