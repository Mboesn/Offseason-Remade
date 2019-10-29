package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotComponents;
import frc.robot.RobotConstants;

/**
 * this is the drivetrain's subsystem
 */
public class Drivetrain extends Subsystem {
  // TODO: add gyro
  private SpeedControllerGroup rightMotors;

  private SpeedControllerGroup leftMotors;

  private DifferentialDrive drivetrain;

  private Encoder rightEncoder;

  private Encoder leftEncoder;

  public Drivetrain() {
    this.rightMotors = new SpeedControllerGroup(RobotComponents.Drivetrain.RIGHT_FRONT_MOTOR,
        RobotComponents.Drivetrain.RIGHT_MIDDLE_MOTOR, RobotComponents.Drivetrain.RIGHT_REAR_MOTOR);

    this.leftMotors = new SpeedControllerGroup(RobotComponents.Drivetrain.LEFT_FRONT_MOTOR,
        RobotComponents.Drivetrain.LEFT_MIDDLE_MOTOR, RobotComponents.Drivetrain.LEFT_REAR_MOTOR);

    this.rightEncoder = RobotComponents.Drivetrain.RIGHT_ENCODER;

    this.leftEncoder = RobotComponents.Drivetrain.LEFT_ENCODER;

    this.drivetrain = new DifferentialDrive(this.leftMotors, this.rightMotors);

    this.rightEncoder.setDistancePerPulse(RobotConstants.Sensors.DRIVETRAIN_DISTANCE_PER_PULSE);

    this.leftEncoder.setDistancePerPulse(RobotConstants.Sensors.DRIVETRAIN_DISTANCE_PER_PULSE);
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
    return rightEncoder.getDistance();
  }

  public Double getLeftDistance() {
    return leftEncoder.getDistance();
  }

  public Double getAverageDistance() {
    return (rightEncoder.getDistance() + leftEncoder.getDistance()) / 2;
  }

  public Double getRightEncoderPID() {
    return rightEncoder.pidGet();
  }

  public Double getLeftEncoderPID() {
    return leftEncoder.pidGet();
  }

  public void resetEncoders() {
    rightEncoder.reset();
    leftEncoder.reset();
  }

  @Override
  public void initDefaultCommand() {
  }
}
