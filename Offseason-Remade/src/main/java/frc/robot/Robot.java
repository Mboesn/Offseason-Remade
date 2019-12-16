package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.CargoCollector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.HatchHolder;
import frc.robot.subsystems.Lift;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  Command autonomousCommand;
  SendableChooser<Command> autoChooser = new SendableChooser<Command>();

  public static Drivetrain drivetrain;

  public static CargoCollector cargoCollector;

  public static HatchHolder hatchHolder;

  public static Lift lift;

  public static OI oi;

  public static RobotStates robotStates;

  @Override
  public void robotInit() {
    oi = new OI();
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", autoChooser);

    drivetrain = new Drivetrain();

    cargoCollector = new CargoCollector();

    hatchHolder = new HatchHolder();

    lift = new Lift();

    robotStates = new RobotStates();

    // sending the value to the dashboard
    // lift pid values
    SmartDashboard.putNumber("lift kp: ", 0);
    SmartDashboard.putNumber("lift ki: ", 0);
    SmartDashboard.putNumber("lift kd: ", 0);
    SmartDashboard.putNumber("lift waitTime: ", 0);
    SmartDashboard.putNumber("lift tolerance: ", 0);
    // cargo holder values
    SmartDashboard.putNumber("cargoCollector power: ", 0);
    SmartDashboard.putNumber("cargoCollector waitTime: ", 0);
    // the desired height of the lift
    SmartDashboard.putString("desired height: ", robotStates.getDesiredHeight().toString());
  }

  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    autonomousCommand = autoChooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
