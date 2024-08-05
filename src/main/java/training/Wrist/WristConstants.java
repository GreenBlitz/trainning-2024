package training.Wrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;

public class WristConstants {

    //* These constants are temp and shall be replaced with calibrated constants that aren't 0

    protected static final String WRIST_LOG_PATH = "";

    protected static final Rotation2d WRIST_UPPER_POSITION = new Rotation2d(0);

    protected static final Rotation2d WRIST_LOWER_POSITION = new Rotation2d(0);


}
