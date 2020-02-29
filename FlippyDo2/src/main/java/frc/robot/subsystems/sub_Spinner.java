/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants;
import com.revrobotics.ColorSensorV3;

public class sub_Spinner extends PIDSubsystem {
  /**
   * Creates a new sub_Spinner.
   */

   private static Spark spinnerMotor = new Spark(Constants.SPINNER_SPARK_ID);
   //private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard); 
   
  public sub_Spinner() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0, 0, 0));
  }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
  }

  public void setSpinnerSpeed(double speed) {
    spinnerMotor.set(speed);
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return 0;
  }
}
