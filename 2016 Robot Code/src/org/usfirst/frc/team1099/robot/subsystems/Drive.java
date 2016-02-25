package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.OI;
import org.usfirst.frc.team1099.robot.RobotMap;
import org.usfirst.frc.team1099.robot.commands.Drive.TeleDrive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANSpeedController.ControlMode;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive drive;
	
	AHRS gyro;
	
	CANTalon l1, r1;
	
	public Drive() {
	
		l1 = new CANTalon(0);
		r1 = new CANTalon(1);
		
		
		// there are a lot of setting for the CAN motors
		// we set everything on the master, and the slave should follow
		
		l1.setVoltageRampRate(12.0);
		r1.setVoltageRampRate(12.0);
		
		l1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		r1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);

		// only need one of these
		l1.reverseSensor(false);
		l1.reverseOutput(false);
		l1.setInverted(true);
		
		r1.reverseSensor(false);
		r1.reverseOutput(false);
		
		// PID settings
		double p = 0.2;
		double i = 0.001;
		double d = 0.00;
		double f = 0.5;
		int izone = 0;
		double ramprate = 36;
		int profile = 0;
		
		// l1.setPID(p, i, d, f, izone, ramprate, profile);
		// r1.setPID(p, i, d, f, izone, ramprate, profile);

		// put things in voltage mode, and all the PID code is ignored
		l1.setVoltageRampRate(60);
		r1.setVoltageRampRate(60);
		
		l1.changeControlMode(TalonControlMode.PercentVbus);
		r1.changeControlMode(TalonControlMode.PercentVbus);
		
		
		// set up the slave for the second Talon for the left drive
		CANTalon l_slave = new CANTalon(2);
		l_slave.changeControlMode(TalonControlMode.Follower);
		l_slave.set(0);
		
		// right slave
		CANTalon r_slave = new CANTalon(3);
		r_slave.changeControlMode(TalonControlMode.Follower);
		r_slave.set(1);
		
		drive = new RobotDrive(l1, r1);
		drive.setExpiration(0.1);
		
		gyro = new AHRS(SPI.Port.kMXP); 
	}
	
	public void drive() {
		double left = OI.leftStick.getRawAxis(1);
		double right = OI.rightStick.getRawAxis(1);
		
		drive(left,right);
	}
	
	public void drive(double left, double right){
		
		l1.set(left);
		r1.set(right);
		
		log();
	}
	
	public void startSpeedControl() {
		l1.changeControlMode(TalonControlMode.Speed);
		r1.changeControlMode(TalonControlMode.Speed);
		
		drive(0,0);
	}
	
	public void speedControlDrive() {
		drive(OI.leftStick.getRawAxis(1),OI.rightStick.getRawAxis(1));
	}
	
	// multiplier
	private double m = .4;
	
	public void gryoDrive(double speed) {
		
		double angle = gyro.getYaw();
		
		// adjust the multiplier according to the magnitude of the difference?
		// (target - angle) or reverse
		
		if ( angle < 0) {
			drive(speed*(1+m), speed);
		} else {
			drive(speed, speed*(1+m));
		}
	}
	
	public void turnAngle(double target){
		
		/**
		double factor = 0.05;
		double maxTurn = 10; //turn 10 degrees
		double actualTurn;

		actualTurn = dif * factor *-1.0;
		
		
		if(actualTurn > maxTurn){
			drive.arcadeDrive(0.0,  maxTurn);
		}
		else if (actualTurn < (maxTurn * -1.0)){
			drive.arcadeDrive(0, maxTurn * -1.0);
		} else {
			drive.arcadeDrive(0, actualTurn);
		}
		**/
		double dif = target - gyro.getYaw();
		double minSpeed = .2;
		double maxSpeed = 1.0;
		double speed = ((maxSpeed-minSpeed)/90)*dif + minSpeed;
		speed = Math.max(speed,1);
		
		if(dif > 0){
			drive(speed,-speed);
		} else {
			drive(-speed,speed);
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

    public void resetPID(){
    	
    	double p = SmartDashboard.getNumber("PID-p", 0.2);
    	double i = SmartDashboard.getNumber("PID-i", 0.001);
    	double d = SmartDashboard.getNumber("PID-d", 0.0);
    	double f = SmartDashboard.getNumber("PID-f", 0.5);
    	
    	// p, i, d, f, izone, ramprate, profile 
    	l1.setPID(p, i, d, f, 0, 12.0, 0);
    	r1.setPID(p, i, d, f, 0, 12.0, 0);
    }
    
}

