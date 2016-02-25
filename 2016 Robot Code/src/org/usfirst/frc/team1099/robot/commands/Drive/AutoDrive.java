package org.usfirst.frc.team1099.robot.commands.Drive;

import org.usfirst.frc.team1099.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {

	private double left = 0.0;
	private double right = 0.0;
	
	public AutoDrive(double speed) {
		
		requires(Robot.drive);
		this.left = speed;
		this.right = speed;
	}
	
	public AutoDrive(double left, double right) {
		
		requires(Robot.drive);
		this.left = left;
		this.right = right;
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		Robot.drive.drive(left, right);
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
