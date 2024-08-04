package training.subsystems.ArmSubsystems.elbowSubsystem;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.AutoLog;

public interface IElbow {

    void goToPosition(Rotation2d targetPosition);
    void stayAtPosition();
    boolean isAtTargetPosition(Rotation2d targetAngle, Rotation2d tolerance);
    void setVoltage(double voltage);
    void setPower(double power);

    void updateInputs(ElbowInputsAutoLogged inputs);


}
