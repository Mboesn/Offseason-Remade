package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * this command locks and unlocks the hatch locker
 */
public class HatchLock extends InstantCommand {

  public HatchLock() {
    super();
    requires(Robot.hatchHolder);
  }

  @Override
  protected void initialize() {
    // the command checks if what the current state of the hatch collecter is and
    // then does the opposite.
    Robot.hatchHolder.setLock(!Robot.robotStates.isHatchHolderLocked());
    Robot.robotStates.setHatchHolderState(!Robot.robotStates.isHatchHolderLocked());
  }

}
