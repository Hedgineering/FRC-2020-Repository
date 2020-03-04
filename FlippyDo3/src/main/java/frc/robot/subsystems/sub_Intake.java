/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.cmd_Intake;

public class sub_Intake extends SubsystemBase {
  /**
   * Creates a new sub_Intake.
   */

  private static Talon intakeMotor = new Talon(Constants.BELT_SPARK_ID);

  public sub_Intake() {
    setDefaultCommand(new cmd_Intake(this));
  }

  public void setIntakeSpeed(double speed){
    intakeMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
