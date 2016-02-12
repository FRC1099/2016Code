package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.Robot;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1099.robot.commands.Intake.stopIntake;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor intakeDrive;
	boolean switched = false;
	

    public Intake(){
    	intakeDrive = new Victor(4);    	
    }
    
    public void startIntake(){
    	if (!switched && Robot.oi.getLeftTrigger() > .01){
    		intakeDrive.set(1);
    	}
    }
    
    public void reverseIntake(){
    	if(Robot.oi.getRightTrigger() > .01){
    		intakeDrive.set(-1);
    	}
    }
    
    public void stopIntake(){
    	intakeDrive.set(0);
    }
    
    public boolean switchOn() {
    	return switched = true;
    }
    
    public boolean switchOff() {
    	return switched = false;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new stopIntake());
    	
    }
    

}

