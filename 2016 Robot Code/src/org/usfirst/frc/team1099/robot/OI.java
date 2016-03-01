package org.usfirst.frc.team1099.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1099.robot.commands.Drive.TurnAngle;
import org.usfirst.frc.team1099.robot.commands.Grabber.ToggleGrab;

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

