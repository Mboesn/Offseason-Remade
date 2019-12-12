package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.AddToDesiredHeight;
import frc.robot.Commands.ChangeLiftHeight;
import frc.robot.Commands.CollectCargo;
import frc.robot.Commands.ToggleHatchLock;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  XboxController driverXbox;

  XboxController operatorXbox;
  // operator buttons
  Button operatorButtonA;
  Button operatorButtonB;
  Button operatorButtonX;
  Button operatorButtonY;
  Button operatorLeftBumper;
  Button operatorRightBumper;

  public OI() {
    driverXbox = new XboxController(0);

    operatorXbox = new XboxController(1);
    // operator buttons
    operatorButtonA = new JoystickButton(operatorXbox, 1);
    operatorButtonB = new JoystickButton(operatorXbox, 2);
    operatorButtonX = new JoystickButton(operatorXbox, 3);
    operatorButtonY = new JoystickButton(operatorXbox, 4);
    operatorLeftBumper = new JoystickButton(operatorXbox, 5);
    operatorRightBumper = new JoystickButton(operatorXbox, 6);

    operatorLeftBumper.whenPressed(new AddToDesiredHeight(-1));
    operatorRightBumper.whenPressed(new AddToDesiredHeight(1));
    // TODO: find real values
    operatorButtonY.whenPressed(new ChangeLiftHeight(0, 0, 0, 0, 0, Robot.robotStates.getDesiredHeight()));
    operatorButtonX.whenPressed(new ToggleHatchLock());
    operatorButtonB.whenPressed(new CollectCargo(true, 0, 0));
    operatorButtonA.whenPressed(new CollectCargo(false, 0, 0));

  }

  public XboxController getdriverXbox() {
    return driverXbox;
  }

}
