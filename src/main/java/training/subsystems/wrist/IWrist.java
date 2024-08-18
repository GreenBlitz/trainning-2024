package training.subsystems.wrist;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IWrist {
    void init();
    void goToAngel(Rotation2d targetAngle);
    boolean isAtAngle(Rotation2d targetAngle);
    Wrist getInstance();
    void stop();
}
