package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.Robot;
import org.usfirst.frc.team1099.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1099.robot.commands.Intake.StartIntake;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor intakeDrive = new Victor(RobotMap.INTAKE); 
	DigitalInput boulder_switch = new DigitalInput(RobotMap.BOULDER_SWITCH);
	
	DoubleSolenoid grab = new DoubleSolenoid(RobotMap.GRAB, RobotMap.UNGRAB);
	public boolean isOpen = true;

    public Intake(){
    	intakeDrive.setInverted(true);
    }
    
    public void startIntake(){
    	
    		double in_speed = SmartDashboard.getNumber("intake_speed", 0.8);
    		
    		if(Robot.oi.getLeftTrigger() > 0.99) {
    			intakeDrive.set(in_speed);
    			//SmartDashboard.putString("Intake", "In");
    		}
    		else if(Robot.oi.getRightTrigger() > 0.99){
    			intakeDrive.set(-1.0);
    			//SmartDashboard.putString("Intake", "Out");
    		}
    		else {
    			intakeDrive.set(0);
    			//SmartDashboard.putString("Intake", "");
    		}
    }
    
	public boolean switchOn() {
    	return !boulder_switch.get();
    }
    
    public boolean switchOff() {
    	return boulder_switch.get();
    }
    
    public void autoEject(){
    	intakeDrive.set(-1.0);
    }
    
    public void ungrab(){
    	grab.set(DoubleSolenoid.Value.kForward);
    	isOpen = true;
    }
    
    public void grab(){
    	grab.set(DoubleSolenoid.Value.kReverse);
    	isOpen = false;
    }
    
	public boolean isOpen() {
		return isOpen;
	}
    
    public void initDefaultCommand() {
    	setDefaultCommand(new StartIntake());
    	
    }
   
}

