package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.RobotMap;
import org.usfirst.frc.team1099.robot.commands.DefenseArm.StopDefenseArm;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DefenseArm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor defensemotor = new Victor(RobotMap.DEFENSEMOTOR);
	
	public void upDefenseArm(){
		double uparmspeed = SmartDashboard.getNumber("up defense arm speed", 0.5);
		defensemotor.set(-uparmspeed);
		//SmartDashboard.putString("DefenseArm", "Up");
	}
	
	public void downDefenseArm() {
		double downarmspeed = SmartDashboard.getNumber("down defense arm speed", 0.35);
		defensemotor.set(downarmspeed);
		//SmartDashboard.putString("DefenseArm", "Down");
	}
	
	public void stopDefenseArm(){
		defensemotor.set(0);
		//SmartDashboard.putString("DefenseArm", "");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopDefenseArm());
    }
}

