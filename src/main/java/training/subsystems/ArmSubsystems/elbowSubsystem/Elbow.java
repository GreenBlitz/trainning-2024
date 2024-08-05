package training.subsystems.ArmSubsystems.elbowSubsystem;

import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.ArmSubsystems.elbowSubsystem.neoElbow.NeoElbow;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

    private IElbow iElbow;

    private static Elbow instance;

    private Elbow() {
        iElbow = ElbowFactory.create();
    }

    public static Elbow getInstance() {
        if (instance == null) {
            instance = new Elbow();
        }
        return instance;
    }

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {
    }


    public void goToPosition(Rotation2d targetPosition) {
        iElbow.goToPosition(targetPosition);
    }

    public void stayAtPosition() {
        iElbow.stayAtPosition();
    }

    public boolean isAtTargetPosition(Rotation2d targetAngle, Rotation2d tolerance) {
        return iElbow.isAtTargetPosition(targetAngle, tolerance);
    }

    public void setVoltage(double voltage) {
        iElbow.setVoltage(voltage);
    }

    public void setPower(double power) {
        iElbow.setPower(power);
    }
}
