package org.usfirst.frc.team1099.robot.commands.LiftArm;

import org.usfirst.frc.team1099.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleLiftExtender extends Command {
	public final int OPEN = 2;
	public final int CLOSED = 3;
	
	private int extender_state = OPEN;

    public ToggleLiftExtender() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.liftarm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if ( extender_state == CLOSED)
		{
			Robot.liftarm.extend();
			extender_state = OPEN;
		}
    	else
    	{
    		Robot.liftarm.retract();
    		extender_state = CLOSED;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
