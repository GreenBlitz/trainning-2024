package training.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.ROLLER_ID;
import static training.Roller.RollerConstants.ROLLER_MOTOR_TYPE;
import static training.Roller.RollerConstants.ROLLER_GEAR_RATIO;
import static training.Roller.RollerConstants.ROLLER_P;
import static training.Roller.RollerConstants.ROLLER_I;
import static training.Roller.RollerConstants.ROLLER_D;
import static training.Roller.RollerConstants.POWER_LIMIT_ROLLER;
import static training.Roller.RollerConstants.ROLLER_DEFAULT_VELOCITY_RPM;
import static training.Roller.RollerConstants.ROLLER_LOG_PATH;

import static training.Roller.RollerDirection.kBackward;
import static training.Roller.RollerDirection.kForward;

public class NeoRoller implements IRoller {
    private final CANSparkMax motor;

    public NeoRoller() {
        this.motor = new CANSparkMax(ROLLER_ID, ROLLER_MOTOR_TYPE);

        motor.getEncoder().setPositionConversionFactor(ROLLER_GEAR_RATIO);
        motor.getPIDController().setP(ROLLER_P);
        motor.getPIDController().setI(ROLLER_I);
        motor.getPIDController().setD(ROLLER_D);
        motor.getPIDController().setOutputRange(-POWER_LIMIT_ROLLER, POWER_LIMIT_ROLLER);
        motor.burnFlash(); // applies some of the changes above

    }

    @Override
    public void updateVelocity(Rotation2d targetVelocity, RollerDirection direction) {
        motor.getPIDController().setReference(targetVelocity.getRotations() * direction.toInt(), CANSparkBase.ControlType.kVelocity);
    }

    @Override
    public Rotation2d getPosition() {
        return new Rotation2d(motor.getEncoder().getPosition());
    }

    @Override
    public Rotation2d getVelocity() {
        return Rotation2d.fromRotations(motor.getEncoder().getVelocity());
    }

    @Override
    public void setPower(double power) {
        motor.set(power);
    }

}
