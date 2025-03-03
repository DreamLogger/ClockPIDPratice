// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.ClockConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ClockCommandDynamic;
import frc.robot.commands.ClockCommandStatic;
import frc.robot.subsystems.ClockSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ClockSubsystem m_clockSubsystem = new ClockSubsystem();

  // The robot's controllers are defined here
  private final CommandXboxController m_OperatorController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  
  private final ClockCommandStatic m_positiony = new ClockCommandStatic(m_clockSubsystem, ClockConstants.positiony);
  private final ClockCommandStatic m_positiona = new ClockCommandStatic(m_clockSubsystem, ClockConstants.positiona);
  private final ClockCommandStatic m_positionx = new ClockCommandStatic(m_clockSubsystem, ClockConstants.positionx);
  private final ClockCommandStatic m_positionb = new ClockCommandStatic(m_clockSubsystem, ClockConstants.positionb);

  private final ClockCommandDynamic clockDynamic = new ClockCommandDynamic(m_clockSubsystem, m_OperatorController ::getRightY);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    m_OperatorController.a().whileTrue(m_positiona);
    m_OperatorController.b().whileTrue(m_positionb);
    m_OperatorController.x().whileTrue(m_positionx);
    m_OperatorController.y().whileTrue(m_positiony);

    m_clockSubsystem.setDefaultCommand(clockDynamic);
  }


  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
