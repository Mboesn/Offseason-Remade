package frc.robot;

/**
 * numarical constants involving the robot
 */
public class RobotConstants {
    public static class Sensors {
        // TODO: find real values
        /** The distance the robot travels every pulse */
        public static final Double DRIVETRAIN_DISTANCE_PER_PULSE = 33.0;
        /** The distance the lift travels every pulse */
        public static final Double LIFT_DISTANCE_PER_PULSE = 33.0;
    }

    public static class RobotDimensions {
    }

    // heights are measured in cm.
    public static enum Height {
        FLOOR_LOW_HATCH(0), HATCH_MIDDLE(71), HATCH_HIGH(142), CARGOSHIP(80), CARGO_LOW(70), CARGO_MIDDLE(141),
        CARGO_HIGH(212);

        private Height(final int height) {
            this.height = height;
        }

        private double height;

        public double getHeight() {
            return height;
        }
    }
}
