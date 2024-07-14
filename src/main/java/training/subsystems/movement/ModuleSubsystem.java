package training.subsystems.movement;

import com.ctre.phoenix6.hardware.TalonFX;
import utils.GBSubsystem;


public class ModuleSubsystem extends GBSubsystem {
    private final TalonFX linearMotor;
    private final TalonFX angularMotor;

    public ModuleSubsystem(int linearMotorId, int rotationalMotorId) {
        linearMotor = new TalonFX(linearMotorId);
        angularMotor = new TalonFX(rotationalMotorId);
    }

    public void setLinearSpeed(double speed) {
        if (Math.abs(speed) <= Constants.MAX_ALLOWED_SPEED) {
            linearMotor.set(speed);
        }
    }

    public void setAngularSpeed(double speed) {
        if (Math.abs(speed) <= Constants.MAX_ALLOWED_SPEED) {
            angularMotor.set(speed);
        }
    }

    public void stopMotors() {
        setLinearSpeed(0);
        setAngularSpeed(0);
    }

    public double getRadAngle() {
        return 2 * Math.PI * (angularMotor.getPosition().getValue() % 1);
    }

    public boolean isAtAngle(double angle, double epsilon) {
        return Math.abs(getRadAngle() - angle) <= epsilon;
    }


    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
