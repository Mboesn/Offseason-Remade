package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * This changes the desiered hieght in the robotstates
 */
public class ChangedDesiredHeight extends InstantCommand {

  private int change;

  public ChangedDesiredHeight(int change) {
    super();
    this.change = change;
  }

  @Override
  protected void initialize() {
    Robot.robotStates.setDesiredHeight(change);
  }

}
