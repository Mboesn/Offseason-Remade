package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This lifts the cargo and hatch collecters
 */
public class Lift extends Subsystem {

  private TalonSRX rightMotor;

  private TalonSRX leftMotor;

  public Lift(){
    this.rightMotor = RobotComponents.Lift.RIGHT_MOTOR;
    this.rightMotor = RobotComponents.Lift.LEFT_MOTOR;
  }

  @Override
  public void initDefaultCommand() {
  }
}
