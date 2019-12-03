package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotComponents;

/**
 * this SS collects and ejects the cargo
 */
public class CargoCollector extends Subsystem {

  private TalonSRX motor;

  public CargoCollector() {
    this.motor = RobotComponents.CargoCollector.MOTOR;
  }

  public void setPower(double power) {
    motor.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void initDefaultCommand() {
  }
}
