package frc.robot.Commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.PIDSources.LiftPIDSource;
import frc.robot.MagicNumbers.Height;

/** this command sets the lift to the desired height */
public class ChangeLiftHeight extends Command {

  /** the values of the pid */
  private double kp, ki, kd;

  /** the time the pid controller should wait on the target */
  private double waitTime;

  /** how large the range of the target is */
  private double tolerance;

  /** the height the lift needs to get to */
  private double desiredHeight;

  private double lastTimeOffTarget;

  private PIDController pidController;

  private LiftPIDSource pidSource;

  /**
   * this checks if we are testing pid and finding values and takes values from
   * the dashboard instead of using set values
   */
  private boolean pidTest;

  public ChangeLiftHeight(double kp, double ki, double kd, double waitTime, double tolerance, Height desiredHeight) {
    this.kp = kp;
    this.ki = ki;
    this.kd = kd;
    this.waitTime = waitTime;
    this.tolerance = tolerance;
    this.desiredHeight = desiredHeight.getHeight();
    pidSource = new LiftPIDSource();
    this.pidTest = false;
  }

  /**
   * this is used to quickly change values using the shuffleboard while finding
   * pid values
   */
  public ChangeLiftHeight(Height desiredHeight) {
    this.desiredHeight = desiredHeight.getHeight();
    pidSource = new LiftPIDSource();
    this.pidTest = true;
  }

  @Override
  protected void initialize() {

    if (pidTest) {
      kp = SmartDashboard.getNumber("lift kp: ", 0);
      ki = SmartDashboard.getNumber("lift ki: ", 0);
      kd = SmartDashboard.getNumber("lift kd: ", 0);
      waitTime = SmartDashboard.getNumber("lift waitTime: ", 0);
      tolerance = SmartDashboard.getNumber("lift tolerance: ", 0);
    }

    pidController = new PIDController(kp, ki, kd, pidSource, (output) -> Robot.lift.setPower(output));
    pidController.setAbsoluteTolerance(tolerance);
    pidController.setOutputRange(-1, 1);
    pidController.setSetpoint(desiredHeight);
    pidController.enable();
  }

  @Override
  protected void execute() {
    if (!pidController.onTarget())
      lastTimeOffTarget = Timer.getFPGATimestamp();
  }

  @Override
  protected boolean isFinished() {
    return Timer.getFPGATimestamp() > (lastTimeOffTarget + waitTime);
  }

  @Override
  protected void end() {
    pidController.disable();
    pidController.close();
    Robot.lift.setPower(0);
  }

  @Override
  protected void interrupted() {
    end();
  }
}
