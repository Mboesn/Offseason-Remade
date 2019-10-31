package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;

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

        public static final Encoder RIGHT_ENCODER = new Encoder(RobotMap.Drivetrain.RIGHT_ENCODER_CHANNEL_A,
                RobotMap.Drivetrain.RIGHT_ENCODER_CHANNEL_B);
        public static final Encoder LEFT_ENCODER = new Encoder(RobotMap.Drivetrain.LEFT_ENCODER_CHANNEL_A,
                RobotMap.Drivetrain.LEFT_ENCODER_CHANNEL_B);
                
        public static final AnalogGyro GYRO = new AnalogGyro(RobotMap.Drivetrain.GYRO);
    }
}
