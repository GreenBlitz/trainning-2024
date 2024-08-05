package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {
    void updateAngle(Rotation2d targetAngle);

    Rotation2d getCurrentAngle();

    Rotation2d getCurrentVelocity();

}
