package org.usfirst.frc.team1099.robot.commands.Drive;

import org.usfirst.frc.team1099.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveStraight extends Command {

	private double speed = 0.0;
	private double target = 0;
	
	public AutoDriveStraight(double speed) {
		
		requires(Robot.drive);
		
		this.speed = speed;
		// get the angle from somewhere
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
