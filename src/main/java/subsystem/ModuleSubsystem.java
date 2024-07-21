package subsystem;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Subsystem;


public class ModuleSubsystem implements Subsystem {
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
        return Constants.RAD_FULL_CIRCLE_ANGLE *
                (angularMotor.getPosition().getValue() % Constants.TALONFX_MOTOR_FULL_CIRCLE);
    }

    public boolean isAtAngle(double angle, double epsilon) {
//        System.out.println("desired: "+angle+", current: "+getRadAngle()+", diff: "+getRadAngle()+", epsilon: "+epsilon);
        return Math.abs(getRadAngle() - angle) <= epsilon;
    }



    protected String getLogPath() {
        return "";
    }


    protected void subsystemPeriodic() {

    }
}