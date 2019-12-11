package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * This changes the desiered height in the robotstates
 */
public class AddToDesiredHeight extends InstantCommand {

  private int change;

  public AddToDesiredHeight(int change) {
    super();
    this.change = change;
  }

  @Override
  protected void initialize() {
    Robot.robotStates.addToDesiredHeight(change);
  }

}
