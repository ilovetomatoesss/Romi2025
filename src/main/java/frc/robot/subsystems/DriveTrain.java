// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.romi.RomiMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//need to import in case it doesn't know the data type
// need to have brand new case in java
// drive train is name of class, below it is the new class/data type
// making new drive train, comes with the things we need
// conversely, in time, they would like in the "teleop" etc etc
// you would call this in robot contianer & change the values

public class DriveTrain extends SubsystemBase {
// can declare ports here
  private RomiMotor m_leftMotor;
  private RomiMotor m_rightMotor;

  /** Creates a new DriveTrain. */
  // or declare ports here
  public DriveTrain(int leftPort, int rightPort) {
    m_leftMotor = new RomiMotor (leftPort);
    m_rightMotor = new RomiMotor (rightPort);

    // found this from documentation, need to use dot to call from package
    m_rightMotor.setInverted(true);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    m_leftMotor.set(leftSpeed);
    m_rightMotor.set(rightSpeed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
