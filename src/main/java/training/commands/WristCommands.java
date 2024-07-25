package training.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import training.subsystems.Wrist.Wrist;
import utils.WristDirection;

public class WristCommands {
    private final static Wrist wristSubsystem = Wrist.getInstance();
    public Command MoveUpWristCommand = new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kUp), wristSubsystem);
    public Command MoveDownWristCommand = new InstantCommand(() -> wristSubsystem.rotate(WristDirection.kDown), wristSubsystem);
}
