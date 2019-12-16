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
   * this checks if we are testing and finding values and takes values from the
   * dashboard instead of using set values
   */
  private boolean test;

  /**
   * @param collect checks if the robot needs to collect or eject the cargo
   */
  public CollectCargo(boolean collect, double power, double waitTime) {
    requires(Robot.cargoCollector);
    if (collect)
      this.power = -power;
    else
      this.power = power;
    this.waitTime = waitTime;
    test = false;
  }

  /**
   * this is used to quickly change values using the shuffleboard while finding
   * values
   */
  public CollectCargo() {
    test = true;
  }

  @Override
  protected void initialize() {

    if (test) {
      power = SmartDashboard.getNumber("cargoCollector power: ", 0);
      waitTime = SmartDashboard.getNumber("cargoCollector waitTime: ", 0);
    }

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
