package training.subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

    void stayAtPosition();

    void goToAngle(Rotation2d targetAngle);

    void updateInputs(ElbowInputsAutoLogged inputs);

}
