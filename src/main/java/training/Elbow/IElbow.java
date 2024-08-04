package training.Elbow;

import com.revrobotics.CANSparkBase;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.Elbow.ElbowConstants.*;
import static training.Elbow.ElbowConstants.PID_SLOT;

public interface IElbow {
    Rotation2d getTargetAngle();

    void setTargetAngle(Rotation2d targetAngle);

    void addToAngle(Rotation2d angle);

    void subtractFromAngle(Rotation2d angle);

    boolean isAtAngle(Rotation2d angle);

    Rotation2d getCurrentAngle();

    void LockElbowInPlace();
}
