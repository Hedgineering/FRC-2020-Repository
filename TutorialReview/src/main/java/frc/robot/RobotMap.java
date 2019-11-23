/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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

  //CAN IDs for Motor Controllers
  public static final int LEFT_MASTER_PORT = 1;
	public static final int RIGHT_MASTER_PORT = 0;
	public static final int LEFT_SLAVE_PORT = 3;
  public static final int RIGHT_SLAVE_PORT = 2;
  
  //Arbitrary values
	public static final double MAX_SPEED = 0.75;
  public static final double DEADZONE = 0.05;
  
  //Controller Port
	public static final int JOYSICK_PORT = 0;
	  public static final int MOVE_AXIS = 1;
    public static final int TURN_AXIS = 0;
    public static final int ARM_ANGLE_AXIS = 5;
    public static final int INPUT_AXIS = 3;
    public static final int OUTPUT_AXIS = 2;
  
  //PWM Port
  public static final int LEFT_ARM_PORT = 0;
	public static final int RIGHT_ARM_PORT = 1;
	public static final int LEFT_JAW_PORT = 2;
	public static final int RIGHT_JAW_PORT = 3;
	
	
	

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
