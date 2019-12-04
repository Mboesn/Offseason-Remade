package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // TODO: set real values

  // Device ID's for devices connected to the CAN bus
  public static class CAN {
    // drivetrain
    public static final int DRIVETRAIN_RIGHT_FRONT_MOTOR = 0;
    public static final int DRIVETRAIN_RIGHT_MIDDLE_MOTOR = 0;
    public static final int DRIVETRAIN_RIGHT_REAR_MOTOR = 0;
    public static final int DRIVETRAIN_LEFT_FRONT_MOTOR = 0;
    public static final int DRIVETRAIN_LEFT_MIDDLE_MOTOR = 0;
    public static final int DRIVETRAIN_LEFT_REAR_MOTOR = 0;

    public static final int DRIVETRAIN_RIGHT_ENCODER = 0;
    public static final int DRIVETRAIN_LEFT_ENCODER = 0;

    // lift
    public static final int LIFT_RIGHT_MOTOR = 0;
    public static final int LIFT_LEFT_MOTOR = 0;

    // cargo collector
    public static final int CARGO_HOLDER_MOTOR = 11;
  }

  // Robot components connected to roboRIO Digital Input Output ports
  static class DIO {
    public static final int GYRO = 0;
  }

  // Solenoid ports connected to PCM
  static class PCM {
    public static final int HATCH_HOLDER_LOCK_SOLENOID_FORWARD = 2;
    public static final int HATCH_HOLDER_LOCK_SOLENOID_REVERSE = 3;
  }
}
