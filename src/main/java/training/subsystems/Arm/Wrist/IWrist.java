package training.subsystems.Arm.Wrist;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IWrist {


    void moveToAngle(Rotation2d position);

    Rotation2d getPosition();

    void stopMotor();

}
