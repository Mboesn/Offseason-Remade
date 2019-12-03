package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CollectCargo extends Command {

  /** The power at which the motor should run */
  private double power;

  /** The time to wait till the cargo is collected */
  private double waitTime;

  /**the time at which the command started runing */
  private double startTime;

  public CollectCargo() {
    requires(Robot.cargoCollector);
    //TODO: find real values
    power = 0.1;
    waitTime = 4;
  }

  @Override
  protected void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  protected void execute() {
    Robot.cargoCollector.setPower(power);
  }

  @Override
  protected boolean isFinished() {
    return Timer.getFPGATimestamp() > (waitTime + startTime);
  }

  @Override
  protected void end() {
    Robot.cargoCollector.setPower(0);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
