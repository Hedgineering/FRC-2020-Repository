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
import frc.robot.commands.ArcadeDrive_Command;

/**
 * Add your docs here.
 */
public class DriveTrain_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX leftMasterMotor = new WPI_TalonSRX(RobotMap.LEFT_MASTER_PORT);
  private WPI_TalonSRX rightMasterMotor = new WPI_TalonSRX(RobotMap.RIGHT_MASTER_PORT);
  private WPI_VictorSPX leftSlaveMotor = new WPI_VictorSPX(RobotMap.LEFT_SLAVE_PORT);
  private WPI_VictorSPX rightSlaveMotor = new WPI_VictorSPX(RobotMap.RIGHT_SLAVE_PORT);

  private DifferentialDrive diffDrive = new DifferentialDrive(leftMasterMotor, rightMasterMotor);

  public DriveTrain_Subsystem(){
    leftSlaveMotor.follow(leftMasterMotor);
    rightSlaveMotor.follow(rightMasterMotor);
  }

  public void drive(double move, double angle){

    //Max Speed Control
    if(move > RobotMap.MAX_SPEED) move = RobotMap.MAX_SPEED;
    if(move < -RobotMap.MAX_SPEED) move = -RobotMap.MAX_SPEED;

    //Deadzone
    if(Math.abs(move) < RobotMap.DEADZONE) move = 0;

    diffDrive.arcadeDrive(move, angle, true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ArcadeDrive_Command());
  }
}
