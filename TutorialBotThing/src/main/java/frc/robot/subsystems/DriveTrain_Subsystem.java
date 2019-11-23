/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveTrain_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(RobotMap.LEFT_MASTER_CONTROLLER);
  private WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(RobotMap.RIGHT_MASTER_CONTROLLER);
  private WPI_VictorSPX leftBackMotor = new WPI_VictorSPX(RobotMap.LEFT_SLAVE_CONTROLLER);
  private WPI_VictorSPX rightBackMotor = new WPI_VictorSPX(RobotMap.RIGHT_SLAVE_CONTROLLER);

  private DifferentialDrive diffDrive;

  public DriveTrain_Subsystem(){

    leftBackMotor.follow(leftFrontMotor);
    rightBackMotor.follow(rightFrontMotor);

    diffDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
  }

  public void drive(double move, double angle){
    //Set the deadzone for the robot
    if(Math.abs(move) < RobotMap.DEADZONE) move = 0;
    
    //Set the Max Speed for the robot
    if(move > RobotMap.MAX_SPEED) move = RobotMap.MAX_SPEED;
    if(move < -RobotMap.MAX_SPEED) move = -RobotMap.MAX_SPEED;

    diffDrive.arcadeDrive(move, angle, true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
