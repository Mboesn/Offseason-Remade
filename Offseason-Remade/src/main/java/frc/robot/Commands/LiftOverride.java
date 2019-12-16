package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftOverride extends Command {
  public LiftOverride() {
    requires(Robot.lift);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.lift.setPower(Robot.oi.getOperatorXbox().getY());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
