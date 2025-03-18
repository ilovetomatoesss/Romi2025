// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.LiftArmCommand;
import frc.robot.commands.MoveWristCommand;
import frc.robot.commands.OpenClawCommand;
import frc.robot.commands.TankDriveCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();

  // make sure all reference is to the same drive train
  // don't use new bc u only have one drive train
  private CommandXboxController m_gamepad = new CommandXboxController(0);
  private DriveTrain m_drivetrain = new DriveTrain (0,1);
  private TankDriveCommand m_tankDriveCmd = new TankDriveCommand(m_drivetrain, m_gamepad);
  
  // every command needs to know its subsystem
  private Arm m_arm = new Arm(2);
  private Claw m_claw = new Claw(4);
  private Wrist m_wrist = new Wrist(3);
  private LiftArmCommand m_liftArmCommand = new LiftArmCommand(m_arm, 30);
  private LiftArmCommand m_resetArmCommand = new LiftArmCommand(m_arm, 0);

  private OpenClawCommand m_openClawCommand = new OpenClawCommand(m_claw, 50);
  private OpenClawCommand m_resetClawCommand = new OpenClawCommand(m_claw, 0);

  private MoveWristCommand m_upWristCommand = new MoveWristCommand(m_wrist, 50);
  private MoveWristCommand m_downWristCommand = new MoveWristCommand(m_wrist, 0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_drivetrain.setDefaultCommand(m_tankDriveCmd);
    m_gamepad.x().whileTrue(m_liftArmCommand);
    m_gamepad.b().whileTrue(m_resetArmCommand);

    m_gamepad.leftTrigger().whileTrue(m_openClawCommand);
    m_gamepad.rightTrigger().whileTrue(m_resetClawCommand);

    m_gamepad.leftBumper().whileTrue(m_upWristCommand);
    m_gamepad.rightBumper().whileTrue(m_downWristCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
