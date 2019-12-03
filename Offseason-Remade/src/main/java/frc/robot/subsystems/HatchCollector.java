package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotComponents;

/**
 * Add your docs here.
 */
public class HatchCollector extends Subsystem {

  private DoubleSolenoid hatchLock;

  private DoubleSolenoid hatchEject;

  public HatchCollector() {
    this.hatchLock = RobotComponents.HatchCollector.HATCH_LOCK;
    this.hatchEject = RobotComponents.HatchCollector.HATCH_EJECT;
  }

  // TODO: check if this is forward or backwards
  // TODO: saftey
  public void setLock(boolean lock) {
    hatchLock.set(lock ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
  }

  // TODO: check if this is forward or backwards
  public void setEject(boolean eject) {
    hatchEject.set(eject ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
  }
}
