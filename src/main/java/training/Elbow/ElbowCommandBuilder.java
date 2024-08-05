package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;


public class ElbowCommandBuilder {
    private final Elbow elbowSubsystem;

    public ElbowCommandBuilder() {
        this.elbowSubsystem = (Elbow) new ElbowFactory().create();
    }


    public Command moveElbowToAngle(Rotation2d targetAngle) {
        return new FunctionalCommand(
                () -> {},
                () -> elbowSubsystem.setTargetAngle(targetAngle),
                (interrupted) -> {},
                () -> elbowSubsystem.isAtAngle(targetAngle),
                elbowSubsystem
        );
    }

    public Command liftElbow() {
        return new SequentialCommandGroup(upElbow(), new WaitCommand(ElbowConstants.DEFAULT_TIME_IN_AIR_ELBOW_SECONDS), downElbow());
    }

    public Command elbowStandInPlace() {
        return new InstantCommand(elbowSubsystem::LockElbowInPlace, elbowSubsystem);
    }

    public Command upElbow() {
        return moveElbowToAngle(ElbowConstants.LIFTING_POSITION_DEGREES);
    }

    public Command downElbow() {
        return moveElbowToAngle(ElbowConstants.LIFTING_POSITION_DEGREES.times(-1));
    }

}
