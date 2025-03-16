// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
//imported this from subsystems
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TankDriveCommand extends Command {

  // new only happens in container, just need to give access here
  private DriveTrain m_drivetrain;
  private CommandXboxController m_gamepad;

  /** Creates a new TankDriveCommand. */
  public TankDriveCommand(DriveTrain iDriveTrain, CommandXboxController iGamepad) {

    //sets so they reference from the same thing
    m_drivetrain = iDriveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    m_gamepad = iGamepad;

    //only one trigger/command can be running at a time
    addRequirements(m_drivetrain);
  }

  public TankDriveCommand(DriveTrain m_drivetrain2) {
    //TODO Auto-generated constructor stub
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStick = -m_gamepad.getLeftY();
    double rightStick = -m_gamepad.getRightY();
    m_drivetrain.tankDrive(leftStick, rightStick);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_drivetrain.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
