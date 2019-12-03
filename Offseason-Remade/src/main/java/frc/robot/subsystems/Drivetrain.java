package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotComponents;
import frc.robot.RobotConstants;

/**
 * this is the drivetrain's subsystem
 */
public class Drivetrain extends Subsystem {

  private SpeedControllerGroup rightMotors;

  private SpeedControllerGroup leftMotors;

  private DifferentialDrive drivetrain;

  private TalonSRX rightEncoder;

  private TalonSRX leftEncoder;

  private AnalogGyro gyro;

  public Drivetrain() {
    this.rightMotors = new SpeedControllerGroup(RobotComponents.Drivetrain.RIGHT_FRONT_MOTOR,
        RobotComponents.Drivetrain.RIGHT_MIDDLE_MOTOR, RobotComponents.Drivetrain.RIGHT_REAR_MOTOR);

    this.leftMotors = new SpeedControllerGroup(RobotComponents.Drivetrain.LEFT_FRONT_MOTOR,
        RobotComponents.Drivetrain.LEFT_MIDDLE_MOTOR, RobotComponents.Drivetrain.LEFT_REAR_MOTOR);

    this.rightEncoder = RobotComponents.Drivetrain.RIGHT_ENCODER;

    this.leftEncoder = RobotComponents.Drivetrain.LEFT_ENCODER;

    this.gyro = RobotComponents.Drivetrain.GYRO;

    this.drivetrain = new DifferentialDrive(this.leftMotors, this.rightMotors);
  }

  public void arcadeDrive(double xPower, double yPower) {
    drivetrain.arcadeDrive(yPower, xPower);
  }

  public void curvatureDrive(double xPower, double yPower, boolean isQuickTurn) {
    drivetrain.curvatureDrive(yPower, xPower, isQuickTurn);
  }

  public void tankDrive(double rightPower, double leftPower) {
    drivetrain.tankDrive(leftPower, rightPower);
  }

  public Double getRightDistance() {
    return rightEncoder.getSelectedSensorPosition() * RobotConstants.Sensors.DRIVETRAIN_DISTANCE_PER_PULSE;
  }

  public Double getLeftDistance() {
    return leftEncoder.getSelectedSensorPosition() * RobotConstants.Sensors.DRIVETRAIN_DISTANCE_PER_PULSE;
  }

  public Double getAverageDistance() {
    return (getRightDistance() + getLeftDistance()) / 2;
  }

  public double getAngle() {
    return gyro.getAngle();
  }

  public double getGyroPID() {
    return gyro.pidGet();
  }

  public void calibrateGyro() {
    gyro.calibrate();
  }

  @Override
  public void initDefaultCommand() {
  }
}
