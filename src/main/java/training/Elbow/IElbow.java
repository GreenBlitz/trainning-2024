package training.Elbow;

import com.revrobotics.CANSparkBase;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.Elbow.ElbowConstants.*;
import static training.Elbow.ElbowConstants.PID_SLOT;

public interface IElbow {
    void updateAngle(Rotation2d targetAngle);

    Rotation2d getCurrentAngle();

    Rotation2d getCurrentVelocity();
}
