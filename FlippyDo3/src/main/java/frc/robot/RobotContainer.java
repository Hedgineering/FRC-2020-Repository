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
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.cmd_ArcadeDrive;
import frc.robot.commands.cmd_Elevator;
import frc.robot.commands.cmd_Intake;
import frc.robot.commands.cmd_Shooter;
import frc.robot.commands.cmd_SpinControlRight;
import frc.robot.commands.cmd_SpinControlStop;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.sub_ControlPanelSpinner;
import frc.robot.subsystems.sub_Drivetrain;
import frc.robot.subsystems.sub_Elevator;
import frc.robot.subsystems.sub_Intake;
import frc.robot.subsystems.sub_Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Subsystems
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final sub_Drivetrain drivetrain = new sub_Drivetrain();
  private final sub_Elevator elevator = new sub_Elevator();
  private static final sub_Shooter shooter = new sub_Shooter();
  private final sub_Intake intake = new sub_Intake();
  private final sub_ControlPanelSpinner spinner = new sub_ControlPanelSpinner();

  //Commands
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final cmd_ArcadeDrive arcadeDriveCommand = new cmd_ArcadeDrive(drivetrain);
  private final cmd_Elevator elevatorCommand = new cmd_Elevator(elevator);
  private final cmd_Intake intakeCommand = new cmd_Intake(intake);
  private final cmd_Shooter shooterCommand = new cmd_Shooter(shooter);

  //Joysticks
  private final static Joystick stick = new Joystick(Constants.JOYSTICK_PORT);
  private final static Joystick moveStick2 = new Joystick(Constants.MOVE_JOYSTICK_PORT_2);

  
  //Buttons
  private final static JoystickButton shootAngleStartButton = new JoystickButton(stick, Constants.SHOOT_ANGLE_START_BUTTON);
  private final static JoystickButton shootAngleEndButton = new JoystickButton(stick, Constants.SHOOT_ANGLE_END_BUTTON);
  private final static JoystickButton spinRightButton = new JoystickButton(stick, Constants.SPIN_RIGHT);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    spinRightButton.whenPressed(new cmd_SpinControlRight(spinner));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  //Return joysticks
  public static Joystick getXbox() {
    return stick;
  }

  public static Joystick getStick() { //Red Stick
    return moveStick2;
  }

  public static sub_Shooter getShooter() { 
    return shooter;
  }
}
