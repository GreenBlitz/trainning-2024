package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import training.subsystems.WristSubsystem;
import utils.WristDirection;

public class WristCommands {
    private final static WristSubsystem wristSubsystem = WristSubsystem.getInstance();
    Command MoveUpWristCommand = new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kUp), wristSubsystem);
    Command MoveDownWristCommand = new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kDown), wristSubsystem);
}
