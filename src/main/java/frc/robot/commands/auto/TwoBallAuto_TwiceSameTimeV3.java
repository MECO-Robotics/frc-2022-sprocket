// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import frc.robot.commands.cargo.Intake;
import frc.robot.commands.cargo.LowerCargoElbow;
import frc.robot.commands.cargo.LowerCargoWrist;
import frc.robot.commands.cargo.Outtake;
import frc.robot.commands.cargo.RaiseCargoElbow;
import frc.robot.commands.cargo.RaiseCargoWrist;
import frc.robot.commands.cargo.Shoot;
import frc.robot.commands.cargo.Stow;
import frc.robot.commands.drive.DriveStraight;
import frc.robot.commands.drive.ResetSensors;
import frc.robot.commands.drive.SpinRightAngle;
import frc.robot.subsystems.DriveSubsystem;

import java.util.Timer;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.CargoSubsystem;

/**
 * Drives the robot autonomously in a prescribed pattern.
 *
 * Refer to this diagram for the routine:
 * https://docs.google.com/drawings/d/1GxrTwsLhETpqVrT3ycNIkLCBsJlLdFQTz0Ca2pnxkw0/edit
 */
public class TwoBallAuto_TwiceSameTimeV3 extends SequentialCommandGroup {

  /**
   * Create a new command.
   *
   * @param driveSubsystem The subsystem used by this command.
   */
  public TwoBallAuto_TwiceSameTimeV3(DriveSubsystem driveSubsystem, CargoSubsystem cargoSubsystem) {

    // Don't need to add the DriveSubsystem as a required subsystem because the
    // commands scheduled will do that.

    addCommands(

       //make sure that the robot is facing away from the hub
       new ResetSensors(driveSubsystem),
       new LowerCargoWrist(cargoSubsystem),
       new WaitCommand(1.5),
       new DriveStraight(driveSubsystem, 12),
       new ParallelCommandGroup(
         new Intake(cargoSubsystem).withTimeout(1.5),
         new DriveStraight(driveSubsystem, 24)
       ),
       new Shoot(cargoSubsystem),
       new SpinRightAngle(driveSubsystem, 180),
       new DriveStraight(driveSubsystem, 78),
       new Outtake(cargoSubsystem).withTimeout(1.5),
       new DriveStraight(driveSubsystem, -24),
      new Stow(cargoSubsystem)
      //orientates the robot for teleop 
      
      
    );
  }
}
