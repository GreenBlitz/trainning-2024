package training.Wrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.Wrist.WristConstants.*;

public class Wrist extends GBSubsystem {
    private Rotation2d targetAngle;
    private final IWrist motor;

    public Wrist() {
        this.motor = new WristFactory().create();
    }

    public void stop() {
        targetAngle = new Rotation2d(0);
        motor.setPower(0);
    }

    public void rotate(WristDirection direction) {
        targetAngle = direction.getValue() == 1 ? WRIST_UPPER_POSITION : WRIST_LOWER_POSITION;
    }

    @Override
    protected String getLogPath() {
        return WRIST_LOG_PATH;
    }

    @Override
    protected void subsystemPeriodic() {
        motor.updateAngle(targetAngle);
    }


}
