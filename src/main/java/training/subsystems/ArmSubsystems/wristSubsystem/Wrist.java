package training.subsystems.ArmSubsystems.wristSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

    private final TalonSRX motor;
    private final Rotation2d targetPosition;
    private static Wrist instance;

    private Wrist() {
        this.motor = new TalonSRX(WristConstants.WRIST_ID);
        this.targetPosition = WristConstants.WRIST_STARTING_POSITION;
        motor.configAllSettings(WristConstants.SRX_CONFIG);
    }

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }

    public void goToPosition(Rotation2d targetPosition) {
        motor.set(ControlMode.Position, targetPosition.getRotations());
    }

    public void stayAtPosition() {
        goToPosition(getPosition());
    }

    public Rotation2d getPosition() {
        return Rotation2d.fromRotations(motor.getSelectedSensorPosition());
    }

    public double getVelocity() {
        return motor.getSelectedSensorVelocity();
    }

    public boolean isAtTargetAngle(Rotation2d targetAngle, Rotation2d tolerance) {
        return (Math.abs(getPosition().minus(targetAngle).getDegrees()) <= tolerance.getDegrees());
    }
}
