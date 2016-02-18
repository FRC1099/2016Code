package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.Robot;
import org.usfirst.frc.team1099.robot.commands.HangArm.StartHangArm;
import org.usfirst.frc.team1099.robot.commands.LiftArm.StartLiftArm;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HangArm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor hangmotor = new Victor(7);
	
	public HangArm(){
	}
	
	public void hangArm() {
		if(Robot.oi.getHangArm() > 0.05 || Robot.oi.getHangArm() < -0.05) {
			hangmotor.set(Robot.oi.getHangArm());
		} else {
			hangmotor.set(0);
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StartHangArm());
    }
}

