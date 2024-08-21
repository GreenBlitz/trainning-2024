package training.subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

    Rotation2d getPosition();

    Rotation2d getVelocity();

    void stayAtPosition();

    void goToAngle(Rotation2d targetAngle);

}
