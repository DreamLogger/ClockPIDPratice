// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClockSubsystem;
import java.util.function.Supplier;

public class ClockCommandDynamic extends Command {
  private final ClockSubsystem m_clockSubsystem;
  Supplier <Double> m_speed;

  public ClockCommandDynamic(ClockSubsystem clockSubsystem,Supplier <Double> speed) {
    m_clockSubsystem = clockSubsystem;
    m_speed = speed;

    addRequirements(clockSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_clockSubsystem.setClockSpeedDyanmic(m_speed.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
