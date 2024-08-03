package training.Wrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import edu.wpi.first.math.geometry.Rotation2d;

import static training.Wrist.WristConstants.WRIST_LOWER_POSITION;
import static training.Wrist.WristConstants.WRIST_UPPER_POSITION;

public interface IWrist {
    public abstract void stop();

    public abstract void rotate(WristDirection direction);
}
