// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.cargo;

import frc.robot.subsystems.CargoSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** Raises the arm. */
public class LowerCargoElbow extends CommandBase {

  private final CargoSubsystem cargo;

  /**
   * Creates a new ExampleCommand.
   *
   * @param cargoSubsystem The subsystem used by this command.
   */
  public LowerCargoElbow(CargoSubsystem cargoSubsystem) {
    cargo = cargoSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    System.out.println("LowerCargoElbow: execute");
    cargo.lowerElbow();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) { 
    System.out.println("LowerCargoElbow: end");
  }

  // Returns true when the command should end. (this command never finishes)
  @Override
  public boolean isFinished() {
    return true;
  }
 
}
