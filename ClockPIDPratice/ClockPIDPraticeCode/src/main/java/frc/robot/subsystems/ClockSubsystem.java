// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClockConstants;

public class ClockSubsystem extends SubsystemBase {
  TalonFX clockMotor;

  TalonFXConfiguration pidConfiguration = new TalonFXConfiguration().withSlot0(new Slot0Configs()
  .withKP(ClockConstants.kClockP)
  .withKI(ClockConstants.kClockI)
  .withKD(ClockConstants.kClockD)
  .withKG(ClockConstants.kClockG)
    .withGravityType(GravityTypeValue.Arm_Cosine));

  public ClockSubsystem() {
    clockMotor = new TalonFX(ClockConstants.clockMotorPort);

    clockMotor.getConfigurator().apply(pidConfiguration);
  }

  public void setClockPostionStatic(double position){
    clockMotor.setControl(new PositionVoltage(position));
  }

  public void setClockSpeedDyanmic(double speed){
    clockMotor.set(ClockConstants.speedDampenerValue * (speed));
  }



  @Override
  public void periodic() {

  }

  @Override
  public void simulationPeriodic() {

  }
}
