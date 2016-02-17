package org.usfirst.frc.team1099.robot.subsystems;


import org.usfirst.frc.team1099.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Grabber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid grab = new DoubleSolenoid(RobotMap.GRAB, RobotMap.UNGRAB);
	public boolean isOpen = true;

    public Grabber() {
    }
    
    public void grab(){
    	grab.set(DoubleSolenoid.Value.kForward);
    	isOpen = false;
    }
    
    public void ungrab(){
    	grab.set(DoubleSolenoid.Value.kReverse);
    	isOpen = true;
    }
    
	public boolean isOpen() {
		return isOpen;
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

