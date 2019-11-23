/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Jaw_Command;

/**
 * Add your docs here.
 */
public class Jaw_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Spark leftJawMotor = new Spark(RobotMap.LEFT_JAW_PORT);
  private Spark rightJawMotor = new Spark(RobotMap.RIGHT_JAW_PORT);

  public void setSpeed(double speed){
    leftJawMotor.set(speed);
    rightJawMotor.set(-speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Jaw_Command());
  }
}
