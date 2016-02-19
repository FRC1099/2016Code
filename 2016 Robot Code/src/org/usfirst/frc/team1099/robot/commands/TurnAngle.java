package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnAngle extends Command {

	public double target;
    public TurnAngle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	target = SmartDashboard.getNumber("Turn Angle"); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetYaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.turnAngle(this.target);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double dif = target - Robot.drive.getYaw();
        return (Math.abs(dif) < 2 );
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
