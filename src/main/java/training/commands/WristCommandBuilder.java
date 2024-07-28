package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import training.subsystems.Wrist.Wrist;
import training.subsystems.Wrist.WristDirection;

public class WristCommandBuilder {
    private final Wrist wristSubsystem;

    public WristCommandBuilder() {
        wristSubsystem = Wrist.getInstance();
    }

    public Command MoveUpWristCommand() {
        return new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kLeft), wristSubsystem);
    }
    public Command MoveDownWristCommand() {
        return new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kRight), wristSubsystem);
    }
}
