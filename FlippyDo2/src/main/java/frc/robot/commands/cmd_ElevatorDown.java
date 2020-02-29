/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class cmd_ElevatorDown extends CommandBase {
  /**
   * Creates a new cmd_ElevatorDown.
   */
  public cmd_ElevatorDown() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.getElevatorSub());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.getStick().getRawButtonPressed(Constants.ELEV_DOWN)){
      RobotContainer.getElevatorSub().setDownSpeed(Constants.ELEV_SPEED);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
