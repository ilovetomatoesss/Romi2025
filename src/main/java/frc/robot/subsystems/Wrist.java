// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase {
  /** Creates a new Wrist. */

  //step 1: create component that the subsystem uses
  private Servo m_servo;

  //step 2: declare where the part is located [in this case, integer is required]
  public Wrist(int iChannel) {
    m_servo = new Servo(iChannel);

  }

  //step 3: create functions for part [in this case, open/close]
  //always need to reach into using . (package)

  public void openAngle(double iAngle) {
    m_servo.setAngle(iAngle);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
