package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.OI;
import org.usfirst.frc.team1099.robot.RobotMap;
import org.usfirst.frc.team1099.robot.commands.Drive.TeleDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive drive = new RobotDrive(RobotMap.LEFTDRIVE, RobotMap.RIGHTDRIVE);
	public double leftStick = 0.0;
    public double rightStick = 0.0;
	
	public Drive () {
		drive.setExpiration(0.1);
	}
	
	public void operatorControl() {
		leftStick = OI.leftStick.getRawAxis(2);
        rightStick = OI.rightStick.getRawAxis(2);
		drive.setSafetyEnabled(true);
        while (true) {
        	drive.tankDrive(OI.leftStick, OI.rightStick);
        }
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleDrive());
    }
}

