/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.SerialPort;

public class sub_Drivetrain extends PIDSubsystem {
  /**
   * Creates a new sub_Drivetrain.
   */

  private final WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(Constants.LEFT_SLAVE_CONTROLLER);
  private final WPI_VictorSPX leftFrontMotor = new WPI_VictorSPX(Constants.LEFT_MASTER_CONTROLLER);
  private final WPI_VictorSPX rightFrontMotor = new WPI_VictorSPX(Constants.RIGHT_MASTER_CONTROLLER);
  private final WPI_VictorSPX rightBackMotor = new WPI_VictorSPX(Constants.RIGHT_SLAVE_CONTROLLER);

  private final AHRS navXAhrs = new AHRS(SerialPort.Port.kUSB);
  //public final Gyro gyro = new ADXRS450_Gyro(Serial.Port.kUSB);
  private final AnalogInput dUltrasonic = new AnalogInput(Constants.DISTANCE_PORT);
  private final SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(Constants.KS_DRIVETRAIN, Constants.KV_DRIVETRAIN);

  private DifferentialDrive diffDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);

  public sub_Drivetrain() {
    super(
        // The PIDController used by the subsystem
        new PIDController(Constants.KP_DRIVETRAIN, Constants.KI_DRIVETRAIN, Constants.KD_DRIVETRAIN));

    getController().setTolerance(Constants.TOLERANCE_DRIVETRAIN);

    diffDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);

    leftBackMotor.follow(leftFrontMotor);

    rightBackMotor.follow(rightFrontMotor);

    
    
  }

    public void arcadeDrive(double move, double angle)
  {
    
    //set max speed
    if(move > Constants.MAX_SPEED) move = Constants.MAX_SPEED;
    if(move < -Constants.MAX_SPEED) move = -Constants.MAX_SPEED;

    //set deadzone
    if(Math.abs(move) < Constants.DEADZONE) move = 0;

    diffDrive.arcadeDrive(-move, angle);
  }

  // public void tankDrive(double leftSpeed, double rightSpeed)
  // {
    
  //   //set max speed
  //   if(leftSpeed > Constants.MAX_SPEED) leftSpeed = Constants.MAX_SPEED;
  //   if(rightSpeed > Constants.MAX_SPEED) rightSpeed = Constants.MAX_SPEED;
  //   if(leftSpeed < -Constants.MAX_SPEED) leftSpeed = -Constants.MAX_SPEED;
  //   if(rightSpeed < -Constants.MAX_SPEED) rightSpeed = -Constants.MAX_SPEED;

  //   //set deadzone
  //   if(Math.abs(rightSpeed) < Constants.DEADZONE) rightSpeed = 0;
  //   if(Math.abs(leftSpeed) < Constants.DEADZONE) leftSpeed = 0;

  //   // leftFrontMotor.set(-leftSpeed);
  //   // rightFrontMotor.set(-rightSpeed);

  //   diffDrive.tankDrive(-leftSpeed, -rightSpeed);

  // }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
    double value = output + feedforward.calculate(setpoint);
    leftFrontMotor.set(value);
    rightFrontMotor.set(value);
  }

  public AHRS getNavGyro(){
    return navXAhrs;
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return navXAhrs.getAngle();               //dUltrasonic.getValue(); //give range in inches
  }
}
