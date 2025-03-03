// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ClockSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


public class ClockCommandStatic extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final double m_position;
  private final ClockSubsystem m_clockSubsystem;


  public ClockCommandStatic(ClockSubsystem clockSubsystem, double position) {
    m_clockSubsystem = clockSubsystem;
    m_position = position;

    addRequirements(clockSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_clockSubsystem.setClockPostionStatic(m_position);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
