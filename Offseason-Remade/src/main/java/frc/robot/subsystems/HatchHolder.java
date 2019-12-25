package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotComponents;

/**
 * this is the hatch holder subsystem
 */
public class HatchHolder extends Subsystem {

  private DoubleSolenoid solenoid;

  public HatchHolder() {
    solenoid = RobotComponents.HatchHolder.SOLENOID;
    /** setting the default state of the hatch collector */
    setLock(true);
  }

  public void setLock(boolean lock) {
    solenoid.set(lock ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
  }
}
