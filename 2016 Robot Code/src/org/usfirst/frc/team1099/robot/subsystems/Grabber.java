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

    public Grabber() {
    }
    
    public void grab(){
    	SmartDashboard.putString("Grab", "Grabbing");
    	grab.set(DoubleSolenoid.Value.kForward);
    }
    
    public void ungrab(){
    	SmartDashboard.putString("Grab", "Un-grabbing");
    	grab.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

