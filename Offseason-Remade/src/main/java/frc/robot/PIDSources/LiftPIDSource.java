package frc.robot.PIDSources;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.robot.Robot;

/**
 * the pid source of the lift, it adds the height of the lift from the floor and
 * dvides the ticks by the ticks per meter
 */
public class LiftPIDSource implements PIDSource {
    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kDisplacement;
    }

    @Override   
    public double pidGet() {
        return Robot.lift.getHeight();
    }
}
