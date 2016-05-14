package org.usfirst.frc.team1099.robot.commands.Intake;

import org.usfirst.frc.team1099.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleGrab extends Command {
	public final int OPEN = 0;
	public final int CLOSED = 1;
	
	private int grab_state = CLOSED;


    public ToggleGrab() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if ( grab_state == OPEN)
		{
			Robot.intake.grab();
			grab_state = CLOSED;
		}
    	else
    	{
    		Robot.intake.ungrab();
    		grab_state = OPEN;
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
