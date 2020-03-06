/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.sub_ControlPanelSpinner;

public class cmd_SpinControlStop extends CommandBase {
    /**
     * Creates a new cmd_SpinControlRight.
     */
    private sub_ControlPanelSpinner spinControlSub;

    public cmd_SpinControlStop(sub_ControlPanelSpinner spin) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(spin);
    spinControlSub = spin;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    spinControlSub.setSpinnerSpeed(0); //Make timeout
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //spinControlSub.setSpinnerSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //spinControlSub.setSpinnerSpeed(0);
    return false;
  }
}
