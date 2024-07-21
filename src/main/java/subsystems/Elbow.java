package subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static subsystems.Constants.DEFAULT_POSITION;
import static subsystems.Constants.ELBOW_ID;

public class Elbow extends SubsystemBase {

    private final CANSparkMax motor = new CANSparkMax(ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
    private Rotation2d angle = DEFAULT_POSITION;
    private boolean run;

    public double getMotorAngle() {
        return motor.getEncoder().getPosition();
    }

    public Rotation2d getDesiredAngle() {
        return angle;
    }

    public void setAngle(Rotation2d angle) {
        this.angle = angle;
    }

    public void addToAngle(Rotation2d angle) {
        this.angle = this.angle.plus(angle);
    }

    public void subtractFromAngle(Rotation2d angle) {
        this.angle = this.angle.minus(angle);
    }

    public void stop() {
        SmartDashboard.putNumber("emergency stop at value (deg) ", angle.getDegrees());

    }

    @Override
    public void periodic() {
        if (run) {
            motor.getPIDController().setReference(angle.getRotations(), CANSparkBase.ControlType.kPosition); // Should be calibrated
        }

    }
}
