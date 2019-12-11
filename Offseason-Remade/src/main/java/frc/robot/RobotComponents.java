package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * This class contains the type of motors and sensors that are used in the robot
 */
public class RobotComponents {

        public static class Drivetrain {
                public static final CANSparkMax RIGHT_FRONT_MOTOR = new CANSparkMax(
                                RobotMap.CAN.DRIVETRAIN_RIGHT_FRONT_MOTOR, MotorType.kBrushless);
                public static final CANSparkMax RIGHT_MIDDLE_MOTOR = new CANSparkMax(
                                RobotMap.CAN.DRIVETRAIN_RIGHT_MIDDLE_MOTOR, MotorType.kBrushless);
                public static final CANSparkMax RIGHT_REAR_MOTOR = new CANSparkMax(
                                RobotMap.CAN.DRIVETRAIN_RIGHT_REAR_MOTOR, MotorType.kBrushless);

                public static final CANSparkMax LEFT_FRONT_MOTOR = new CANSparkMax(
                                RobotMap.CAN.DRIVETRAIN_LEFT_FRONT_MOTOR, MotorType.kBrushless);
                public static final CANSparkMax LEFT_MIDDLE_MOTOR = new CANSparkMax(
                                RobotMap.CAN.DRIVETRAIN_LEFT_MIDDLE_MOTOR, MotorType.kBrushless);
                public static final CANSparkMax LEFT_REAR_MOTOR = new CANSparkMax(
                                RobotMap.CAN.DRIVETRAIN_LEFT_REAR_MOTOR, MotorType.kBrushless);

                // the encoders are not connected to the same motor controllers as the motors
                public static final TalonSRX RIGHT_ENCODER = new TalonSRX(RobotMap.CAN.DRIVETRAIN_RIGHT_ENCODER);
                // this motor is also connected to the cargo collector motor
                public static final TalonSRX LEFT_ENCODER = CargoCollector.MOTOR;

                public static final AnalogGyro GYRO = new AnalogGyro(RobotMap.DIO.GYRO);
        }

        public static class Lift {
                public static final TalonSRX RIGHT_MOTOR = new TalonSRX(RobotMap.CAN.LIFT_RIGHT_MOTOR);
                public static final TalonSRX LEFT_MOTOR = new TalonSRX(RobotMap.CAN.LIFT_LEFT_MOTOR);
        }

        public static class CargoCollector {
                public static final TalonSRX MOTOR = new TalonSRX(RobotMap.CAN.CARGO_HOLDER_MOTOR);
        }

        public static class HatchHolder {
                public static final DoubleSolenoid SOLENOID = new DoubleSolenoid(
                                RobotMap.PCM.HATCH_HOLDER_SOLENOID_FORWARD, RobotMap.PCM.HATCH_HOLDER_SOLENOID_REVERSE);
        }
}
