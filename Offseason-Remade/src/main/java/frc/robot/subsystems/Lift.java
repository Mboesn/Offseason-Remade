package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotComponents;

/**
 * This lifts the cargo and hatch collecters
 */
public class Lift extends Subsystem {

  private TalonSRX rightMotor;

  private TalonSRX leftMotor;

  public Lift(){
    this.rightMotor = RobotComponents.Lift.RIGHT_MOTOR;
    this.leftMotor = RobotComponents.Lift.LEFT_MOTOR;

    this.leftMotor.follow(this.rightMotor);
  }

  public void setPower(double power){
    rightMotor.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void initDefaultCommand() {
  }
}
