/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class sub_Flywheel extends SubsystemBase {
  /**
   * Creates a new sub_Flywheel.
   */
  private Spark flyWheelMotor = new Spark(Constants.FLYWHEEL_SPARK_ID);
  public sub_Flywheel() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setFlywheelSpeed (double speed){
    flyWheelMotor.set(speed);
  }
}
