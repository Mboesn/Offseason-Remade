package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotComponents;

/**
 * Add your docs here.
 */
public class HatchCollector extends Subsystem {

  private DoubleSolenoid hatchLock;

  public HatchCollector() {
    this.hatchLock = RobotComponents.HatchCollector.HATCH_LOCK;
  }

  public void setLock(boolean lock) {
    hatchLock.set(lock ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
  }
}
