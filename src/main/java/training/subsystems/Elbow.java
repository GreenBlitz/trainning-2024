package training.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.ElbowConstants;
import training.subsystems.NeoElbow.NeoElbow;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {
    private final IElbow elbow;

    public Elbow() {
        elbow = new NeoElbow();
    }

    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {
    }


    public void moveToAngle(Rotation2d position) {
        elbow.moveToAngle(position);
    }

    public Rotation2d getPosition() {
        return elbow.getPosition();
    }

    public void stopMotor() {
        elbow.stopMotor();
    }

}
