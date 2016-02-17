package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.OI;
import org.usfirst.frc.team1099.robot.RobotMap;
import org.usfirst.frc.team1099.robot.commands.Drive.TeleDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive drive;
	
	public Drive() {
		drive = new RobotDrive(RobotMap.LEFTDRIVE, RobotMap.RIGHTDRIVE);
		drive.setExpiration(0.1);
	}
	
	public void drive() {
		drive.tankDrive(-OI.leftStick.getRawAxis(1), -OI.rightStick.getRawAxis(1));	
		}
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleDrive());
    }
}

