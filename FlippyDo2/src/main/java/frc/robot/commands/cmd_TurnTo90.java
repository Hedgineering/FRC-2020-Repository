/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class cmd_TurnTo90 extends PIDCommand {
  /**
   * Creates a new cmd_TurnTo90.
   */
  public cmd_TurnTo90() {
    super(
        // The controller that the command will use
        new PIDController(Constants.KP_DRIVETRAIN, Constants.KI_DRIVETRAIN, Constants.KD_DRIVETRAIN),
        // This should return the measurement
        () -> RobotContainer.getDriveTrainSub().getMeasurement(),
        // This should return the setpoint (can also be a constant)
        () -> Constants.SETPOINT_DRIVETRAIN,
        // This uses the output
        output -> {
          // Use the output here
            RobotContainer.getDriveTrainSub().arcadeDrive(0, output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.getDriveTrainSub());
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
