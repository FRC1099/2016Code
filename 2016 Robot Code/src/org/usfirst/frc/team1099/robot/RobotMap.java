package org.usfirst.frc.team1099.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	
	//Motor Ports:
	public static final int LEFTDRIVE = 0;
	public static final int RIGHTDRIVE = 1;
	
	//Joystick Ports:
	public static final int LEFTSTICK = 0;
    public static final int RIGHTSTICK = 1;
    public static final int GAMEPAD = 2;
    
    //Gamepad Buttons:
    //public static final int TOGGLE_GRAB = 1;
    public static final int GRABBUTTON = 3;
    public static final int UN_GRABBUTTON = 4;

    //Gamepad Axes:
    public static final int INTAKE_IN = 2;
    public static final int INTAKE_OUT = 3;
    
    
    //Solenoid Channels
    public static final int GRAB = 0;
    public static final int UNGRAB = 1;
    
    //Digital Inputs:
    public static final int BOULDER_SWITCH = 4;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
