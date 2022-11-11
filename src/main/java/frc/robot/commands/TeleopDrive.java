// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TeleopDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final driveTrain drivetrain;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TeleopDrive(driveTrain driveTrain) {
    this.drivetrain=driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      Robot.m_robotContainer.getDriverLeftTrigger();
    if(Robot.m_robotContainer.getRightBumperPressed()){
        drivetrain.frontRight.set(TalonFXControlMode.PercentOutput,-Robot.m_robotContainer.getDriverRightTrigger());}
    else{drivetrain.frontLeft.set(TalonFXControlMode.PercentOutput,Robot.m_robotContainer.getDriverLeftTrigger());}
    if(Robot.m_robotContainer.getLeftBumperPressed()){
        drivetrain.frontRight.set(TalonFXControlMode.PercentOutput,-Robot.m_robotContainer.getDriverLeftTrigger());}
    else{      
      drivetrain.frontRight.set(TalonFXControlMode.PercentOutput,Robot.m_robotContainer.getDriverRightTrigger());}
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
