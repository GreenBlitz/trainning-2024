package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

    void setPower(double power);

    void moveElbowToPosition(Rotation2d position);

    void stayAtPosition();

    Rotation2d getPosition();

    Rotation2d getVelocity();

    boolean isAtPosition(Rotation2d target);
}
