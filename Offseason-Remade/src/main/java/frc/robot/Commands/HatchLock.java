package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * this command locks and unlocks the hatch locker
 */
public class HatchLock extends InstantCommand {

  private boolean lock;

  public HatchLock(boolean lock) {
    super();
    requires(Robot.hatchCollector);
    this.lock = lock;
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.hatchCollector.setLock(lock);
  }

}
