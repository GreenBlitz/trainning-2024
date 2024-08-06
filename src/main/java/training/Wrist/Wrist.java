package training.Wrist;

import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.Wrist.WristConstants.*;

public class Wrist extends GBSubsystem {
    private Rotation2d targetAngle;
    private final IWrist iWrist;

    public Wrist() {
        this.iWrist = new WristFactory().create();
    }

    public void stop() {
        targetAngle = new Rotation2d(0);
        iWrist.setPower(0);
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
        iWrist.updateAngle(targetAngle);
    }


}
