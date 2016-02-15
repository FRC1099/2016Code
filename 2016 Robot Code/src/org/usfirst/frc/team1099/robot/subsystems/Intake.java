package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.Robot;
import org.usfirst.frc.team1099.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1099.robot.commands.Intake.startIntake;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor intakeDrive = new Victor(3);
	DigitalInput boulder_switch = new DigitalInput(RobotMap.BOULDER_SWITCH);

    public Intake(){
    }
    
    public void startIntake(){
    	SmartDashboard.putBoolean("Boulder Switch", boulder_switch.get());
    	if(boulder_switch.get()){
    		if(Robot.oi.getLeftTrigger() > 0.99) {
    			intakeDrive.set(0.9);
    		}
    		else if(Robot.oi.getRightTrigger() > 0.99){
    			intakeDrive.set(0.3);
    		}
    		else {
    			intakeDrive.set(0);
    		}
    	}
    }
	public boolean switchOn() {
    	return !boulder_switch.get();
    }
    
    public boolean switchOff() {
    	return boulder_switch.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new startIntake());
    	
    }
    

}

