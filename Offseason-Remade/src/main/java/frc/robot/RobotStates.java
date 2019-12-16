package frc.robot;

import frc.robot.MagicNumbers.Height;

/**
 * this class saves all the states at which the robot is in so it could know how
 * to take action
 */
public class RobotStates {
    private boolean isHatchHolderLocked;
    private int desiredHeight;

    private Height[] heights = new MagicNumbers.Height[] { Height.FLOOR, Height.HATCH_LOW, Height.CARGOSHIP, Height.CARGO_LOW,
            Height.HATCH_MIDDLE, Height.CARGO_MIDDLE, Height.HATCH_HIGH, Height.CARGO_HIGH };

    public Height getDesiredHeight() {
        return heights[desiredHeight];
    }

    public void addToDesiredHeight(int desiredHeight) {
        desiredHeight += desiredHeight;
    }

    public boolean isHatchHolderLocked() {
        return isHatchHolderLocked;
    }

    public void toggleHatchHolderState() {
        isHatchHolderLocked = !isHatchHolderLocked;
    }
}
