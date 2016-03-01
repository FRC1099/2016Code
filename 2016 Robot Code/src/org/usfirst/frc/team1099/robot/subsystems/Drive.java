package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.OI;
import org.usfirst.frc.team1099.robot.RobotMap;
import org.usfirst.frc.team1099.robot.commands.Drive.TeleDrive;

import com.kauailabs.navx.frc.AHRS;
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
	
	//CANJaguar l1, r1;
	CANTalon l1, r1;
	
	/*
	public Drive() {

		l1 = new CANJaguar(RobotMap.LEFTDRIVE_JCAN);
		r1 = new CANJaguar(RobotMap.RIGHTDRIVE_JCAN);
		
		
		// there are a lot of setting for the CAN motors
		// we set everything on the master, and the slave should follow
		
		l1.setVoltageRampRate(60.0);
		r1.setVoltageRampRate(60.0);
		
		//l1.setFeedbackDevice(CANJaguar.FeedbackDevice.QuadEncoder);
		//r1.setFeedbackDevice(CANJaguar.FeedbackDevice.QuadEncoder);

		//Used during Voltage Control
		
		// Used during Speed Control
		l1.reverseSensor(false);
		l1.reverseOutput(false);
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
		
		/*l1.setPID(p, i, d, f, izone, ramprate, profile);
		r1.setPID(p, i, d, f, izone, ramprate, profile);
		
		//Put into Voltage Control
		l1.setPercentMode();
		r1.setPercentMode();
		
		l1.enableControl();
		r1.enableControl();
		
		gyro = new AHRS(SPI.Port.kMXP); 
	}
	*/
	
	public Drive() {
		
		l1 = new CANTalon(RobotMap.LEFTDRIVE_CAN);
		r1 = new CANTalon(RobotMap.RIGHTDRIVE_CAN);
		
		
		// there are a lot of setting for the CAN motors
		// we set everything on the master, and the slave should follow
		
		l1.setVoltageRampRate(60.0);
		r1.setVoltageRampRate(60.0);
		
		l1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		r1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);

		//Used during Voltage Control
		l1.setInverted(false);
		r1.setInverted(true);
		
		// Used during Speed Control
		l1.reverseSensor(false);
		l1.reverseOutput(false);
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
		
		l1.setPID(p, i, d, f, izone, ramprate, profile);
		r1.setPID(p, i, d, f, izone, ramprate, profile);
		
		//Put into Voltage Control
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
		
		gyro = new AHRS(SPI.Port.kMXP); 
	}
	
	public void drive() {
		double left = -OI.leftStick.getRawAxis(1);
		double right = -OI.rightStick.getRawAxis(1);
		
		drive(left,right);		
	}
	
	//Main Drive Method...Should Always be called
	public void drive(double left, double right){
		
		l1.set(left);
		r1.set(right);
		log();
		
	}
	
	public void startSpeedControl() {
		//l1.changeControlMode(TalonControlMode.Speed);
		//r1.changeControlMode(TalonControlMode.Speed);
		
		//drive(0,0);
	}
	
	//public void speedControlDrive() {
		//drive(OI.leftStick.getRawAxis(1),OI.rightStick.getRawAxis(1));
	//}
	
	// multiplier
	private double m = .4;
	
	public void gryoDrive(double speed) {
		
		double angle = gyro.getYaw();
		double threshold = 2;

		// adjust the multiplier according to the magnitude of the difference?
		// (target - angle) or reverse
		
		if (angle > threshold) {
			drive(speed*(1-m), speed*(1+m));
		} else if ( angle < -threshold) {
			drive(speed*(1+m), speed*(1-m));
		} else {
			drive(speed,speed);
		}
	}
	
	public void turnAngle(double target){
		
		
		
		double dif = target - gyro.getYaw();

		double minSpeed = SmartDashboard.getNumber("minSpeed", .3);
		double maxSpeed = SmartDashboard.getNumber("maxSpeed", .5);
		
		double speed = ((maxSpeed-minSpeed)/64800.0)*dif*dif + (dif*(maxSpeed-minSpeed))/360.0 + minSpeed;
		speed = Math.min(speed,maxSpeed);
		
		SmartDashboard.putNumber("speed", speed);
		SmartDashboard.putNumber("yaw", gyro.getYaw());
		SmartDashboard.putNumber("diff", dif);
		
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
    	
    	//double p = SmartDashboard.getNumber("PID-p", 0.2);
    	//double i = SmartDashboard.getNumber("PID-i", 0.001);
    	//double d = SmartDashboard.getNumber("PID-d", 0.0);
    	//double f = SmartDashboard.getNumber("PID-f", 0.5);
    	
    	// p, i, d, f, izone, ramprate, profile 
    	//l1.setPID(p, i, d, f, 0, 12.0, 0);
    	//r1.setPID(p, i, d, f, 0, 12.0, 0);
    }
}

