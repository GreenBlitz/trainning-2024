package training.subsystems.Arm.Elbow;

import com.revrobotics.CANSparkBase;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {
    protected static Elbow instance;
    protected static IElbow iElbow;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public static Elbow getInstance() {
        if (instance == null) {
            instance = new Elbow();
        }
        return instance;
    }

    public void setVoltage(double voltage) {
        iElbow.setVoltage(voltage);
    }



    public boolean isAtPosition(Rotation2d target){
        return Math.abs(iElbow.getPosition().getDegrees() - target.getDegrees()) <= ElbowConstants.TOLERANCE;
    }
}
