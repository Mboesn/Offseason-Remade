package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;

/**
 * This class contains the type of motors and sensors that are used in the robot
 */
public class RobotComponents {

    public static class Drivetrain {
        public static final CANSparkMax RIGHT_FRONT_MOTOR = new CANSparkMax(RobotMap.Drivetrain.RIGHT_FRONT_MOTOR,
                MotorType.kBrushless);
        public static final CANSparkMax RIGHT_MIDDLE_MOTOR = new CANSparkMax(RobotMap.Drivetrain.RIGHT_MIDDLE_MOTOR,
                MotorType.kBrushless);
        public static final CANSparkMax RIGHT_REAR_MOTOR = new CANSparkMax(RobotMap.Drivetrain.RIGHT_REAR_MOTOR,
                MotorType.kBrushless);

        public static final CANSparkMax LEFT_FRONT_MOTOR = new CANSparkMax(RobotMap.Drivetrain.LEFT_FRONT_MOTOR,
                MotorType.kBrushless);
        public static final CANSparkMax LEFT_MIDDLE_MOTOR = new CANSparkMax(RobotMap.Drivetrain.LEFT_MIDDLE_MOTOR,
                MotorType.kBrushless);
        public static final CANSparkMax LEFT_REAR_MOTOR = new CANSparkMax(RobotMap.Drivetrain.LEFT_REAR_MOTOR,
                MotorType.kBrushless);

        // the encoders are not connected to the same motor controllers as the motors
        public static final TalonSRX RIGHT_ENCODER = new TalonSRX(RobotMap.Drivetrain.RIGHT_ENCODER);
        // this motor is also connected to the cargo collector motor
        public static final TalonSRX LEFT_ENCODER = new TalonSRX(RobotMap.Drivetrain.LEFT_ENCODER);
                
        public static final AnalogGyro GYRO = new AnalogGyro(RobotMap.Drivetrain.GYRO);
    }
}
