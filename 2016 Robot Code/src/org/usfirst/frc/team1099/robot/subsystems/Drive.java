package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.OI;
import org.usfirst.frc.team1099.robot.RobotMap;
import org.usfirst.frc.team1099.robot.commands.Drive.TeleDrive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive drive;
	
	AHRS gyro;
	
	
	public Drive() {
		drive = new RobotDrive(RobotMap.LEFTDRIVE, RobotMap.RIGHTDRIVE);
		drive.setExpiration(0.1);
		
		gyro = new AHRS(SPI.Port.kMXP); 
	}
	
	public void drive() {
		drive.tankDrive(-OI.leftStick.getRawAxis(1), -OI.rightStick.getRawAxis(1));	
		log();
	}
	
	public void autoDrive(double left, double right) {
		drive.tankDrive(left, right);
		log();
	}
	
	public void autoDrive(double speed) {
		autoDrive(speed, speed);
	}
	
	// multiplier
	private double m = .4;
	
	public void gryoDrive(double speed) {
		
		double angle = gyro.getYaw();
		
		// adjust the multiplier according to the magnitude of the difference?
		// (target - angle) or reverse
		
		if ( angle < 0) {
			autoDrive(speed*(1+m), speed);
		} else {
			autoDrive(speed, speed*(1+m));
		}
	}
	
	public void turnAngle(double target){
		double dif = target - gyro.getYaw();
		double factor = 0.05;
		double maxTurn = 10; //turn 10 degrees
		double actualTurn;
	System.out.print(dif);
	System.out.print("\n");
		actualTurn = dif * factor *-1.0;
		
		if(actualTurn > maxTurn){
			drive.arcadeDrive(0.0,  maxTurn);
		}
		else if (actualTurn < (maxTurn * -1.0)){
			drive.arcadeDrive(0, maxTurn * -1.0);
		} else {
			drive.arcadeDrive(0, actualTurn);
		}
		
	}

	public double getYaw(){
		return gyro.getYaw();
	}
	
	public void resetYaw(){
		gyro.zeroYaw();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new TeleDrive());
    }
    
    private void log() {
    	SmartDashboard.putNumber("Angle", gyro.getAngle());
    }

}

