package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotComponents;

/**
 * Add your docs here.
 */
public class HatchCollector extends Subsystem {

  private DoubleSolenoid hatchLock;

  public HatchCollector(){
    this.hatchLock = RobotComponents.HatchCollector.HATCH_LOCK;
  }
//TODO: check if this is forward or backwards
//TODO: saftey
  public void setLock(boolean lock){
    hatchLock.set(lock ?  DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
  }
}
