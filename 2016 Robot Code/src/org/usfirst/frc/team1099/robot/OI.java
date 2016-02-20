package org.usfirst.frc.team1099.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1099.robot.commands.GyroDrive;
import org.usfirst.frc.team1099.robot.commands.TurnAngle;
import org.usfirst.frc.team1099.robot.commands.Grabber.Grab;
import org.usfirst.frc.team1099.robot.commands.Grabber.ToggleGrab;
import org.usfirst.frc.team1099.robot.commands.Grabber.Un_Grab;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
   
	public static Joystick leftStick;
    public static Joystick rightStick;
    public static Joystick gamepad;
    
    public OI () {
    	leftStick = new Joystick(RobotMap.LEFTSTICK);
        rightStick = new Joystick(RobotMap.RIGHTSTICK);
        gamepad = new Joystick(RobotMap.GAMEPAD);
        
        Button togglegrab = new JoystickButton(gamepad, RobotMap.TOGGLE_INTAKE);
        togglegrab.whenPressed(new ToggleGrab());
        
        // drive straight
        Button go_straight = new JoystickButton(gamepad, 4);
        go_straight.whileHeld( new GyroDrive(.5));
        Button turnAngle = new JoystickButton(gamepad, RobotMap.TURN_ANGLE);
        turnAngle.whenPressed(new TurnAngle());
    }
    
    public double getLeftTrigger() {
		return gamepad.getRawAxis(RobotMap.BALL_IN);
	}
	
	public double getRightTrigger() {
		return gamepad.getRawAxis(RobotMap.BALL_OUT);
	}
	
	public double getLiftArm() {
		return gamepad.getRawAxis(RobotMap.LIFT_ARM);
	}
	
	public double getHangArm() {
		return gamepad.getRawAxis(RobotMap.HANG_ARM);
	}
}

