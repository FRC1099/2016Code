
package org.usfirst.frc.team1099.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1099.robot.commands.DoNothing;
import org.usfirst.frc.team1099.robot.commands.DriveForward;
import org.usfirst.frc.team1099.robot.commands.DriveForwardDrop;
import org.usfirst.frc.team1099.robot.commands.DriveForwardCheval;
import org.usfirst.frc.team1099.robot.commands.DriveForwardScore;
import org.usfirst.frc.team1099.robot.commands.DriveForwardScoreMoat;
import org.usfirst.frc.team1099.robot.commands.DriveForwardScoreRamparts;
import org.usfirst.frc.team1099.robot.commands.Drive.TurnAngle;
import org.usfirst.frc.team1099.robot.subsystems.DefenseArm;
import org.usfirst.frc.team1099.robot.subsystems.Drive;
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
	public static final DefenseArm defensearm = new DefenseArm();
	public static final LiftArm liftarm = new LiftArm();

	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;
    
    CameraServer camserver;

    public Robot() {
    	camserver = CameraServer.getInstance();
        camserver.setQuality(50);
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

        chooser.addDefault("Drive Forward Standard", new DriveForward());
        chooser.addObject("Do Nothing", new DoNothing());
        chooser.addObject("Drive Forward, Turn Right, Score", new DriveForwardScore(DriveForwardScore.RIGHT));
        chooser.addObject("Drive Forward, Turn Left, Score", new DriveForwardScore(DriveForwardScore.LEFT));
        chooser.addObject("Drive Forward Ramparts, Turn Right, Score", new DriveForwardScoreRamparts(DriveForwardScore.RIGHT));
        chooser.addObject("Drive Forward Ramparts, Turn Left, Score", new DriveForwardScoreRamparts(DriveForwardScore.LEFT));
        chooser.addObject("Drive Forward Moat, Turn Right, Score", new DriveForwardScoreMoat(DriveForwardScore.RIGHT));
        chooser.addObject("Drive Forward Moat, Turn Left, Score", new DriveForwardScoreMoat(DriveForwardScore.LEFT));
        chooser.addObject("Drive Forward, Ball Out", new DriveForwardDrop());
        //chooser.addObject("Portculis Arm Down, Drive Forward, Up, Forward", new DriveForwardPortculis());
        chooser.addObject("Drive Forward Cheval", new DriveForwardCheval());
        chooser.addObject("Drive Forward Rough Terrain", new DriveForward(.8, 2.0));
        chooser.addObject("Drive Forward Moat", new DriveForward(1.0, 2.5));
        
        SmartDashboard.putData("Auto mode", chooser);
        
        //SmartDashboard.putData("Intake", Robot.intake);
        //SmartDashboard.putData("Drive", Robot.drive);
        //SmartDashboard.putData("Lift Arm", Robot.liftarm);
        //SmartDashboard.putData("DefenseArm", Robot.defensearm);
    
        //SmartDashboard.putNumber("Turn Angle", 90.0);
        SmartDashboard.putNumber("intake_speed", 0.8);
        SmartDashboard.putNumber("lift arm motor speed", 1.0);
        SmartDashboard.putNumber("lift arm winch speed", 1.0);
        SmartDashboard.putNumber("up defense arm speed", 0.5);
        SmartDashboard.putNumber("down defense arm speed", 0.35);
        
        // seed the PID settings
        //SmartDashboard.putNumber("PID-p", 0.2);
    	//SmartDashboard.putNumber("PID-i", 0.001);
    	//SmartDashboard.putNumber("PID-d", 0.0);
    	//SmartDashboard.putNumber("PID-f", 0.5);
    	
        // add some command shortcuts
        //SmartDashboard.putData("Do -90 Degrees", new TurnAngle(-90));
        //SmartDashboard.putData("Do 45 Degrees", new TurnAngle(45));
        
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
    	
    	// try to reset the yaw here to avoid drift during game delays, which
    	// seem to make us start off going to the side.
    	drive.resetYaw();
    	
        autonomousCommand = (Command) chooser.getSelected();
        
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        
        // hard coded auto selection
        // autonomousCommand =  new DriveForward();
        // autonomousCommand.start();
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
