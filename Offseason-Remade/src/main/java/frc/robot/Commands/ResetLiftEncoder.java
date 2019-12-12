package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * This command resets the encoder, should be used at the start of the match
 * while the lift is at its lowest point
 */
public class ResetLiftEncoder extends InstantCommand {

  public ResetLiftEncoder() {
    requires(Robot.lift);
  }

  @Override
  protected void initialize() {
    Robot.lift.resetEncoders();
  }

}
