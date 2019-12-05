package frc.robot;

import frc.robot.RobotConstants.Height;

/**
 * this class saves all the states at which the robot is in so it could know how
 * to take action
 */
public class RobotStates {
    private boolean isHatchCollectorLocked;
    private int desiredHeight;

    private Height[] heights = new RobotConstants.Height[] { Height.FLOOR_LOW_HATCH, Height.CARGOSHIP, Height.CARGO_LOW,
            Height.HATCH_MIDDLE, Height.CARGO_MIDDLE, Height.HATCH_HIGH, Height.CARGO_HIGH };

    public Height getDesiredHeight() {
        return heights[desiredHeight];
    }

    public void setDesiredHeight(int desiredHeight) {
        this.desiredHeight += desiredHeight;
    }

    public boolean isHatchCollectorLocked(){
        return isHatchCollectorLocked;
    }

    public void setCollectorState(boolean isLocked) {
        this.isHatchCollectorLocked = isLocked;
    }
}
