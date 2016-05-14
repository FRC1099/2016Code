package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.Robot;
import org.usfirst.frc.team1099.robot.RobotMap;
import org.usfirst.frc.team1099.robot.commands.LiftArm.StartLiftArm;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftArm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor liftmotor = new Victor(RobotMap.LIFTMOTOR);
	Victor liftwinch = new Victor(RobotMap.LIFTWINCH);
	DoubleSolenoid liftextender = new DoubleSolenoid(RobotMap.LIFTEXTEND, RobotMap.LIFTRETRACT);
	public boolean isOpen = true;
	
	public void startLiftMotor() {
		double armspeed = SmartDashboard.getNumber("lift arm motor speed", 1.0);
		if(Robot.oi.getLeftAxis() > 0.3) {
			liftmotor.set(armspeed);
			//SmartDashboard.putString("LiftMotor", "Up");
		}
		else if(Robot.oi.getLeftAxis() < -0.3){
			liftmotor.set(-armspeed);
			//SmartDashboard.putString("LiftMotor", "Down");
		}
		else {
			liftmotor.set(0);
			//SmartDashboard.putString("LiftMotor", "");
		}
	}
	
	public void AutoLiftMotor(double speed) {
		liftmotor.set(speed);
	}
	
	public void startLiftWinch() {
		double winchspeed = SmartDashboard.getNumber("lift arm winch speed", 1.0);
		if(Robot.oi.getRightAxis() > 0.3) {
			liftwinch.set(winchspeed);
			//SmartDashboard.putString("LiftWinch", "Up");
		}
		else if(Robot.oi.getRightAxis() < -0.3 && Robot.oi.gamepad.getRawButton(8)){
			liftwinch.set(-winchspeed);
			//SmartDashboard.putString("LiftWinch", "Down");
		}
		else {
			liftwinch.set(0);
			//SmartDashboard.putString("LiftWinch", "");
		}
	}
	
	public void extend(){
    	liftextender.set(DoubleSolenoid.Value.kForward);
    	isOpen = true;
    }
    
    
    public void retract(){
    	liftextender.set(DoubleSolenoid.Value.kReverse);
    	isOpen = false;
    }
    
	public boolean isOpen() {
		return isOpen;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StartLiftArm());
    }
}

