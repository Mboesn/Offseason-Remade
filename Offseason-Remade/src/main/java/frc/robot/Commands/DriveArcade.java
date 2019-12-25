package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveArcade extends Command {

  private Supplier<Double> xAxisInput;
  
  private Supplier<Double> yAxisInput;

  public DriveArcade(Supplier<Double> xAxisInput, Supplier<Double> yAxisInput) {
    requires(Robot.drivetrain);
    this.xAxisInput = xAxisInput;
    this.yAxisInput = yAxisInput;
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.drivetrain.arcadeDrive(xAxisInput.get(), yAxisInput.get());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.drivetrain.arcadeDrive(0, 0);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
