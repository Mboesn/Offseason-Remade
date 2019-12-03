package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * this commands ejects and unejects the hatch collector
 */
public class HatchEject extends InstantCommand {

  private boolean eject;

  public HatchEject(boolean eject) {
    super();
    requires(Robot.hatchCollector);
    this.eject = eject;
  }

  @Override
  protected void initialize() {
    Robot.hatchCollector.setEject(eject);
  }

}
