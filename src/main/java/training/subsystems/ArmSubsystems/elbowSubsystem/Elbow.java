package training.subsystems.ArmSubsystems.elbowSubsystem;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.commands.ArmCommands.elbowCommands.ElbowDefultCommand;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {

    private final CANSparkMax motor;

    private static Elbow instance;

    private Elbow() {
        this.motor = new CANSparkMax(ElbowConstants.ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
        motor.getEncoder().setPositionConversionFactor(ElbowConstants.ELBOW_GEAR_RATIO.getDegrees());
        motor.getPIDController().setP(ElbowConstants.ELBOW_P_VALUE);
        motor.getPIDController().setI(ElbowConstants.ELBOW_I_VALUE);
        motor.getPIDController().setD(ElbowConstants.ELBOW_D_VALUE);
        motor.getEncoder().setPosition(ElbowConstants.ELBOW_STARTING_POSITION.getDegrees());
    }

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

    public void goToPosition(Rotation2d position) {
        motor.getPIDController().setReference(
                position.getDegrees(),
                CANSparkBase.ControlType.kPosition,
                0,
                ElbowConstants.ARM_FEEDFORWARD.calculate(getPosition().getRadians(), getVelocity())
        );
    }

    public void stayAtPosition() {
        goToPosition(getPosition());
    }

    public Rotation2d getPosition() {
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public double getVelocity() {
        return motor.getEncoder().getVelocity();
    }

    public boolean isAtTargetAngle(Rotation2d targetAngle, Rotation2d tolerance) {
        return (Math.abs(getPosition().minus(targetAngle).getDegrees()) <= tolerance.getDegrees());
    }

}