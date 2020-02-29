/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
//PWM Values
public static final int FLYWHEEL_SPARK_ID = 5;
public static final int SPINNER_SPARK_ID = 8;
public static final int BELT_SPARK_ID = 0;
public static int LEFT_ELEV_ID = 3;
public static int RIGHT_ELEV_ID = 2;

//CAN ID
    //Drivetrain
    public static final int LEFT_MASTER_CONTROLLER = 4;
	public static final int LEFT_SLAVE_CONTROLLER = 5;
	public static final int RIGHT_MASTER_CONTROLLER = 0;
	public static final int RIGHT_SLAVE_CONTROLLER = 1;

//Analog Values
public static final int DISTANCE_PORT = 0;

//DIO Values

//Controllers / Joysticks
public static final int JOYSTICK_PORT = 0;
public static final int MOVE_JOYSTICK_PORT = 1; // Left  (NotRed Joystick)
public static final int MOVE_JOYSTICK_PORT_2 = 2; // Right (Red Joystick)

public static final int SHOOT_ANGLE_START_BUTTON = 3; //x button
public static final int SHOOT_ANGLE_END_BUTTON = 2; //x button

//Axes
    //Drivetrain
    public static final int MOVE_AXIS = 1; // Left Analog Y
    public static final int TURN_AXIS = 0; // Left Analog X

    public static final int LEFT_MOVE_AXIS = 1; //Left Analog Y
    public static final int RIGHT_MOVE_AXIS = 1; //Right Analog Y

    //Shooter
    public static final int BELT_AXIS = 2; // Left Trigger
    public static final int FLYWHEEL_AXIS = 3; // Right Trigger

    //Spinner
    public static final int SPINNER_AXIS = 4; // Right Analog X


//Buttons
public static final int ELEV_DOWN = 1; // A Button
public static final int ELEV_UP = 4; // Y Button


//Arbitrary Constants
public static final double MAX_SPEED = .75;
public static final double DEADZONE = 0.05;
public static final double ELEV_SPEED = 0.5;

//PID Values
public static final double KP_DRIVETRAIN = 18;
public static final double KI_DRIVETRAIN = .5;
public static final double KD_DRIVETRAIN = 2.5;
public static final double TOLERANCE_DRIVETRAIN = 0;

public static final double KS_DRIVETRAIN = 0; //ks static gain
public static final double KV_DRIVETRAIN = 0; //kv velocity gain

public static final double kRangeMultiplier = .125;               //0.00678794461;
public static final double SETPOINT_DRIVETRAIN = 90;


}
