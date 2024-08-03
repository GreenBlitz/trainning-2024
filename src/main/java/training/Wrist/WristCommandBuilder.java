package training.Wrist;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class WristCommandBuilder {
    private final NeoWrist wristSubsystem;

    public WristCommandBuilder() {
        this.wristSubsystem = NeoWrist.getInstance();
    }

    public Command MoveUpWrist() {
        return new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kLeft), wristSubsystem);
    }
    public Command MoveDownWrist() {
        return new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kRight), wristSubsystem);
    }
}
