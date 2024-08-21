package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

    void moveToAngle(Rotation2d position);

    Rotation2d getPosition();

    void stopMotor();

}
