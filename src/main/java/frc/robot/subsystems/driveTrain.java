// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.TeleopDrive;

public class driveTrain extends SubsystemBase {
    public WPI_TalonFX frontLeft = new WPI_TalonFX(3);
    public WPI_TalonFX frontRight = new WPI_TalonFX(1);
    private WPI_TalonFX backLeft = new WPI_TalonFX(4);
    private WPI_TalonFX backRight = new WPI_TalonFX(2);

    public DifferentialDrive motors = new DifferentialDrive(frontLeft, frontRight);
    public TeleopDrive teleopDrive = new TeleopDrive(this);
    private WPI_TalonFX[] allMotors={frontLeft, frontRight, backLeft, backRight};
    public void configMotors() {
        for(WPI_TalonFX motor : allMotors){
            motor.setNeutralMode(NeutralMode.Brake);
        }
        frontLeft.setInverted(TalonFXInvertType.CounterClockwise);
        frontRight.setInverted(TalonFXInvertType.CounterClockwise);
        backLeft.setInverted(TalonFXInvertType.CounterClockwise);
        backRight.setInverted(TalonFXInvertType.CounterClockwise);
    }

  /** Creates a new ExampleSubsystem. */
  public driveTrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
