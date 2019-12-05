package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class CollectCargo extends Command {

  /** The power at which the motor should run */
  private double power;

  /** The time to wait till the cargo is collected */
  private double waitTime;

  /** the time at which the command started runing */
  private double startTime;

  /**
   * @param collect checks if the robot needs to collect or eject the cargo
   */
  public CollectCargo(boolean collect, double power, double waitTime) {
    requires(Robot.cargoCollector);
    if (collect)
      this.power = power;
    else
      this.power = -power;
    this.waitTime = 4;
  }

  public CollectCargo(boolean collect) {
    this(collect, SmartDashboard.getNumber("cargoCollector power: ", 0),
        SmartDashboard.getNumber("cargoCollector waitTime: ", 0));
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
