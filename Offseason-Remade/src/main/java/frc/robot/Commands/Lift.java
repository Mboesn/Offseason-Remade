package frc.robot.Commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.PIDSources.LiftPIDSource;

/** this command sets the lift to the desired height */
public class Lift extends Command {

  /** the values of the pid */
  private double kp, kd, ki;

  /** the time the pid controller should wait on the target */
  private double waitTime;

  /** how large the range of the target is */
  private double tolerance;

  /** the height the lift needs to get to */
  private double desiredHeight;

  private double lastTimeOffTarget;

  private PIDController pidController;

  private LiftPIDSource pidSource;

  public Lift(double kp, double kd, double ki, double waitTime, double tolerance, double desiredHeight) {
    this.kp = kp;
    this.ki = ki;
    this.kd = kd;
    this.waitTime = waitTime;
    this.tolerance = tolerance;
    this.desiredHeight = desiredHeight;
  }

  /**
   * this is used to quickly change values using the shuffleboard while finding
   * pid values
   */
  public Lift(double desiredHeight) {
    this(SmartDashboard.getNumber("kp: ", 0), SmartDashboard.getNumber("ki: ", 0), SmartDashboard.getNumber("kd: ", 0),
        SmartDashboard.getNumber("waitTime: ", 0), SmartDashboard.getNumber("tolerance: ", 0), desiredHeight);
  }

  @Override
  protected void initialize() {
    pidController = new PIDController(kp, ki, kd, pidSource, (x) -> Robot.lift.setPower(x));
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
