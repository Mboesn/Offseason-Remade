package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotComponents;
import frc.robot.MagicNumbers.Sensors;

/**
 * This lifts the cargo and hatch collecters
 */
public class Lift extends Subsystem {

  private TalonSRX rightMotor;

  private TalonSRX leftMotor;

  private TalonSRX encoder;

  public Lift() {
    rightMotor = RobotComponents.Lift.RIGHT_MOTOR;
    leftMotor = RobotComponents.Lift.LEFT_MOTOR;
    encoder = RobotComponents.Lift.ENCODER;

    leftMotor.follow(rightMotor);
    leftMotor.setInverted(InvertType.OpposeMaster);
  }

  public void setPower(double power) {
    rightMotor.set(ControlMode.PercentOutput, power);
  }

  public void resetEncoders() {
    encoder.setSelectedSensorPosition(0);
  }

  public double getHeight() {
    return encoder.getSelectedSensorPosition() * Sensors.LIFT_DISTANCE_PER_PULSE;
  }

  @Override
  public void initDefaultCommand() {
  }
}
