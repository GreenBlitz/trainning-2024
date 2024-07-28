package training.Wrist;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class WristCommandBuilder {
    private final Wrist wristSubsystem;

    public WristCommandBuilder() {
        this.wristSubsystem = Wrist.getInstance();
    }

    public Command MoveUpWristCommand() {
        return new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kLeft), wristSubsystem);
    }
    public Command MoveDownWristCommand() {
        return new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kRight), wristSubsystem);
    }
}
