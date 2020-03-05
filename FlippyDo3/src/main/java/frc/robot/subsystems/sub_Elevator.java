/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.cmd_Elevator;

public class sub_Elevator extends SubsystemBase {
  /**
   * Creates a new sub_Elevator.
   */
  private VictorSPX leftElevatorMotor = new VictorSPX(Constants.LEFT_ELEV_ID);
  private VictorSPX rightElevatorMotor = new VictorSPX(Constants.RIGHT_ELEV_ID);
  
  public sub_Elevator() {
    setDefaultCommand(new cmd_Elevator(this));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setSpeed (double speed){
    if(speed > Constants.UP_SPEED){
      speed = Constants.UP_SPEED;
    }
    else if(speed < Constants.DOWN_SPEED){
      speed = Constants.DOWN_SPEED;
    }
    leftElevatorMotor.set(ControlMode.PercentOutput, speed);
    rightElevatorMotor.set(ControlMode.PercentOutput, -speed);
  }
}
