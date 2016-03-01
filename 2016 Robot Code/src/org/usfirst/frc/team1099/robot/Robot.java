
package org.usfirst.frc.team1099.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1099.robot.commands.DoNothing;
import org.usfirst.frc.team1099.robot.commands.DriveAndTurn;
import org.usfirst.frc.team1099.robot.commands.DriveForward;
import org.usfirst.frc.team1099.robot.commands.Drive.TurnAngle;
import org.usfirst.frc.team1099.robot.subsystems.Drive;
import org.usfirst.frc.team1099.robot.subsystems.Grabber;
import org.usfirst.frc.team1099.robot.subsystems.HangArm;
import org.usfirst.frc.team1099.robot.subsystems.Intake;
import org.usfirst.frc.team1099.robot.subsystems.LiftArm;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final Drive drive = new Drive();
	public static final Intake intake = new Intake();
	public static final Grabber grabber = new Grabber();
	public static final HangArm hangarm = new HangArm();
	public static final LiftArm liftarm = new LiftArm();

	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;
    
    CameraServer camserver;

    public Robot() {
        camserver = CameraServer.getInstance();
        camserver.setQuality(25);
        //the camera name (ex "cam0") can be found through the roborio web interface
        camserver.startAutomaticCapture("cam1");
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
        chooser = new SendableChooser();

        chooser.addObject("Do Nothing", new DoNothing());
        chooser.addObject("DriveAndTurn", new DriveAndTurn());
        chooser.addObject("Drive Forward", new DriveForward());
        
        SmartDashboard.putData("Auto mode", chooser);
        
        SmartDashboard.putData("Grabber", Robot.grabber );
        SmartDashboard.putData("Intake", Robot.intake );
        SmartDashboard.putData("Drive", Robot.drive );
    
        SmartDashboard.putNumber("Turn Angle", 90.0);
        
        SmartDashboard.putNumber("intake_speed", 0.8);
        
        // seed the PID settings
        //SmartDashboard.putNumber("PID-p", 0.2);
    	//SmartDashboard.putNumber("PID-i", 0.001);
    	//SmartDashboard.putNumber("PID-d", 0.0);
    	//SmartDashboard.putNumber("PID-f", 0.5);
    	
        // add some command shortcuts
        SmartDashboard.putData("Do -90 Degrees", new TurnAngle(-90));
        SmartDashboard.putData("Do 45 Degrees", new TurnAngle(45));
        SmartDashboard.putNumber("maxSpeed", .5);
        SmartDashboard.putNumber("minSpeed", .3);
        
        //SmartDashboard.putData("Reset PID", new ResetPID());
        
        
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
