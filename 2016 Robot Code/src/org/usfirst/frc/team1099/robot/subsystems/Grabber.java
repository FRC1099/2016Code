package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid grab = new DoubleSolenoid(RobotMap.GRAB, RobotMap.UNGRAB);
	
	private boolean isGrab = false; 

    public Grabber() {
    }
    
    public void grab(){
    		grab.set(DoubleSolenoid.Value.kForward);
    		isGrab = true;
    }
    
    public void ungrab(){
    		grab.set(DoubleSolenoid.Value.kReverse);
    }
    
    public boolean isGrab(){
    	return isGrab;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

