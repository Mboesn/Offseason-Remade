package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotComponents;
import frc.robot.Commands.DriveArcade;
import frc.robot.MagicNumbers.Sensors;

/**
 * this is the drivetrain's subsystem
 */
public class Drivetrain extends Subsystem {

  private DifferentialDrive drivetrain;

  private TalonSRX rightEncoder;

  private TalonSRX leftEncoder;

  private AnalogGyro gyro;

  public Drivetrain() {
    rightEncoder = RobotComponents.Drivetrain.RIGHT_ENCODER;

    leftEncoder = RobotComponents.Drivetrain.LEFT_ENCODER;

    gyro = RobotComponents.Drivetrain.GYRO;

    drivetrain = new DifferentialDrive(
        new SpeedControllerGroup(RobotComponents.Drivetrain.LEFT_FRONT_MOTOR,
            RobotComponents.Drivetrain.LEFT_MIDDLE_MOTOR, RobotComponents.Drivetrain.LEFT_REAR_MOTOR),
        new SpeedControllerGroup(RobotComponents.Drivetrain.RIGHT_FRONT_MOTOR,
            RobotComponents.Drivetrain.RIGHT_MIDDLE_MOTOR, RobotComponents.Drivetrain.RIGHT_REAR_MOTOR));
  }

  /**
   * this functions are inverted beacuse wpi use x as forward and z as rotation
   * but we use x rotation and y forward do not change back
   */
  public void arcadeDrive(double xPower, double yPower) {
    drivetrain.arcadeDrive(yPower, xPower);
  }

  /**
   * this functions are inverted beacuse wpi use x as forward and z as rotation
   * but we use x rotation and y forward do not change back
   */
  public void curvatureDrive(double xPower, double yPower, boolean isQuickTurn) {
    drivetrain.curvatureDrive(yPower, xPower, isQuickTurn);
  }

  public void tankDrive(double leftPower, double rightPower) {
    drivetrain.tankDrive(leftPower, rightPower);
  }

  public Double getRightDistance() {
    return rightEncoder.getSelectedSensorPosition() * Sensors.DRIVETRAIN_DISTANCE_PER_PULSE;
  }

  public Double getLeftDistance() {
    return leftEncoder.getSelectedSensorPosition() * Sensors.DRIVETRAIN_DISTANCE_PER_PULSE;
  }

  public Double getAverageDistance() {
    return (getRightDistance() + getLeftDistance()) / 2;
  }

  public double getAngle() {
    return gyro.getAngle();
  }

  /** get the gyro for use as a PID source */
  public AnalogGyro getGyro() {
    return gyro;
  }

  public void calibrateGyro() {
    gyro.calibrate();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveArcade(() -> Robot.oi.getdriverXbox().getX(), () -> Robot.oi.getdriverXbox().getY()));
  }
}
