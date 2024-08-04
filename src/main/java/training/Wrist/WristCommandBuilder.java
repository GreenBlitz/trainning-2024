package training.Wrist;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class WristCommandBuilder {
    private final Wrist wristSubsystem;

    public WristCommandBuilder() {
        this.wristSubsystem = new Wrist();
    }

    public Command MoveUpWrist() {
        return new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kLeft), wristSubsystem);
    }
    public Command MoveDownWrist() {
        return new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kRight), wristSubsystem);
    }

}
