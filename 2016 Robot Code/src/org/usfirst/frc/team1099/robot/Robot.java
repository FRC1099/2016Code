
package org.usfirst.frc.team1099.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1099.robot.commands.DriveAuto;
import org.usfirst.frc.team1099.robot.commands.Spin;
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
    
   CameraServer robocam;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		robocam = CameraServer.getInstance();
		robocam.setQuality(50);
		robocam.startAutomaticCapture("cam0");
		
        chooser = new SendableChooser();
//      chooser.addObject("My Auto", new MyAutoCommand());
        chooser.addDefault("Drive Forward", new DriveAuto());
        chooser.addDefault("Spin", new Spin());
        SmartDashboard.putData("Auto mode", chooser);
        
        SmartDashboard.putData("Grabber", Robot.grabber );
        SmartDashboard.putData("Intake", Robot.intake );
        SmartDashboard.putData("Drive", Robot.drive );
    
        SmartDashboard.putNumber("Turn Angle", 0);
        
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
