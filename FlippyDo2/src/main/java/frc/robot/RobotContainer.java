/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.cmd_ArcadeDrive;
import frc.robot.commands.cmd_ElevatorDown;
import frc.robot.commands.cmd_ElevatorUp;
import frc.robot.commands.cmd_Flywheel;
import frc.robot.commands.cmd_Spinner;
import frc.robot.commands.cmd_TurnTo90;
import frc.robot.subsystems.sub_Drivetrain;
import frc.robot.subsystems.sub_Elevator;
import frc.robot.subsystems.sub_Flywheel;
import frc.robot.subsystems.sub_Intake;
import frc.robot.subsystems.sub_Spinner;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final static sub_Drivetrain drivetrain = new sub_Drivetrain();
    

  private final static cmd_ArcadeDrive arcadeDrive = new cmd_ArcadeDrive();
  private final static cmd_TurnTo90 turn90 = new cmd_TurnTo90();

  private final static sub_Spinner spinner = new sub_Spinner();
  private final static cmd_Spinner spin = new cmd_Spinner();

  private final static sub_Intake intake = new sub_Intake();

  private final static sub_Flywheel flywheel = new sub_Flywheel();
  private final static cmd_Flywheel fly = new cmd_Flywheel();
  
  private final static sub_Elevator elevator = new sub_Elevator();
  private final static cmd_ElevatorUp elevUp = new cmd_ElevatorUp();
  private final static cmd_ElevatorDown elevDown = new cmd_ElevatorDown();
  //make intake command

  private final static Joystick stick = new Joystick(Constants.JOYSTICK_PORT);
    //Buttons
    private final static JoystickButton shootAngleStartButton = new JoystickButton(stick, Constants.SHOOT_ANGLE_START_BUTTON);
    private final static JoystickButton shootAngleEndButton = new JoystickButton(stick, Constants.SHOOT_ANGLE_END_BUTTON);
  private final static Joystick moveStick = new Joystick(Constants.MOVE_JOYSTICK_PORT);
  private final static Joystick moveStick2 = new Joystick(Constants.MOVE_JOYSTICK_PORT_2);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }


/**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    shootAngleStartButton.whileHeld(turn90); // lines up when x is pressed
    //shootAngleEndButton.whenPressed(new InstantCommand(drivetrain::disable, drivetrain)); // lines up when b is pressed

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public static sub_Drivetrain getDriveTrainSub() {
    // An sub_Drivetrain will run in autonomous
    // return m_autoCommand;
    return drivetrain;
  }

  public Command getTurnTo90Command() {
    // An cmd_ArcadeDrive will run in autonomous
    // return m_autoCommand;
    return turn90;
  }

  public static sub_Spinner getSpinnerSub() {
    // An sub_Spinner will run in autonomous
    // return m_autoCommand;
    return spinner;
  }

  public static Command getSpinCmd() {
    // An cmd_Spinner will run in autonomous
    // return m_autoCommand;
    return spin;
  }

  public static sub_Intake getIntake(){
    return intake;
  }

  public static sub_Flywheel getFlywheelSub() {
    // An sub_Flywheel will run in autonomous
    // return m_autoCommand;
    return flywheel;
  }

  public Command getFlyCmd() {
    // An cmd_Flywheel will run in autonomous
    // return m_autoCommand;
    return fly;
  }


  public static sub_Elevator getElevatorSub() {
    // An sub_Elevator will run in autonomous
    // return m_autoCommand;
    return elevator;
  }

  public Command getElevUpCmd() {
    // An cmd_ElevatorUp will run in autonomous
    // return m_autoCommand;
    return elevUp;
  }

  public Command getElevDownCmd() {
    // An cmd_ElevatorDown will run in autonomous
    // return m_autoCommand;
    return elevDown;
  }

  public static Command getArcadeDriveCmd() {
    // An cmd_Spinner will run in autonomous
    // return m_autoCommand;
    return arcadeDrive;
  }

  public static Joystick getStick() {
    return stick;
  }

  public static Joystick getMoveStick() {
    return moveStick;
  }

  public static Joystick getMoveStick2() {
    return moveStick2;
  }
}
