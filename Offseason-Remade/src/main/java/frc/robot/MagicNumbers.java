package frc.robot;

/**
 * numarical constants
 */
public class MagicNumbers {

    public static class Miscellaneous {
        public static final double COLLECT_CARGO_WAIT_TIME = 5;
        public static final double EJECT_CARGO_WAIT_TIME = 1;
        public static final double CARGO_COLLECT_AND_EJECT_POWER = 0.3;
    }

    public static class Sensors {
        // TODO: find real values
        /** The distance the robot travels every pulse */
        public static final Double DRIVETRAIN_DISTANCE_PER_PULSE = 1.0;
        /** The distance the lift travels every pulse */
        public static final Double LIFT_DISTANCE_PER_PULSE = 1.0;
    }

    public static class RobotDimensions {
    }

    // heights are measured in cm.
    public static enum Height {
        FLOOR(0), HATCH_LOW(0), HATCH_MIDDLE(71), HATCH_HIGH(142), CARGOSHIP(80), CARGO_LOW(70), CARGO_MIDDLE(141),
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
