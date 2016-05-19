package org.usfirst.frc.team1099.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1099.robot.commands.DefenseArm.DownDefenseArm;
import org.usfirst.frc.team1099.robot.commands.DefenseArm.UpDefenseArm;
import org.usfirst.frc.team1099.robot.commands.Intake.ToggleGrab;
import org.usfirst.frc.team1099.robot.commands.LiftArm.ToggleLiftExtender;

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
        
        Button toggleliftextender = new JoystickButton(gamepad, RobotMap.TOGGLE_LIFTEXTEND);
        toggleliftextender.whenPressed(new ToggleLiftExtender());
        	
        Button downdefensearm = new JoystickButton(gamepad, RobotMap.DOWNDEFENSEARM);
        downdefensearm.whileHeld(new DownDefenseArm());
        
        Button updefensearm = new JoystickButton(gamepad, RobotMap.UPDEFENSEARM);
        updefensearm.whileHeld(new UpDefenseArm());
    }
    
    public double getLeftTrigger() {
		return gamepad.getRawAxis(RobotMap.BALL_IN);
	}
	
	public double getRightTrigger() {
		return gamepad.getRawAxis(RobotMap.BALL_OUT);
	}
	
	public double getRightAxis() {
		return gamepad.getRawAxis(RobotMap.LIFTWINCHAXIS);
	}
	
	public double getLeftAxis() {
		return gamepad.getRawAxis(RobotMap.LIFTAXIS);
	}
}

