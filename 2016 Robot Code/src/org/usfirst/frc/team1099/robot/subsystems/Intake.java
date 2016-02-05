package org.usfirst.frc.team1099.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor intakeDrive;
	

    public Intake(){
    	intakeDrive = new Victor(4);
    	
    }
    
    public void startIntake(){
    	intakeDrive.set(1.0);
    }
    
    public void reverseIntake(){
    	intakeDrive.set(-1.0);
    }
    
    public void stopIntake(){
    	intakeDrive.set(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    

}

