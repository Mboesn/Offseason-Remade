package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.ChangeLiftHeight;
import frc.robot.Commands.ChangedDesiredHeight;
import frc.robot.Commands.CollectCargo;
import frc.robot.Commands.HatchLock;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick driverJoystick = new Joystick(0);

  Joystick operatorJoystick = new Joystick(1);
  // operator buttons
  Button operatorButtonA = new JoystickButton(operatorJoystick, 0);
  Button operatorButtonB = new JoystickButton(operatorJoystick, 1);
  Button operatorButtonX = new JoystickButton(operatorJoystick, 2);
  Button operatorButtonY = new JoystickButton(operatorJoystick, 3);
  Button operatorLeftBumper = new JoystickButton(operatorJoystick, 4);
  Button operatorRightBumper = new JoystickButton(operatorJoystick, 5);

  public OI() {

    operatorLeftBumper.whenPressed(new ChangedDesiredHeight(-1));
    operatorRightBumper.whenPressed(new ChangedDesiredHeight(1));
    // TODO: find real values
    operatorButtonY.whenPressed(new ChangeLiftHeight(0, 0, 0, 0, 0, Robot.robotStates.getDesiredHeight()));
    operatorButtonX.whenPressed(new HatchLock());
    operatorButtonB.whenPressed(new CollectCargo(true, 0, 0));
    operatorButtonA.whenPressed(new CollectCargo(false, 0, 0));

  }

  public Joystick getDriverJoystick() {
    return driverJoystick;
  }

}
