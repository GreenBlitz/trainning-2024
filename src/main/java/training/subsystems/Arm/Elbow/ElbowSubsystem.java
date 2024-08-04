package training.subsystems.Arm.Elbow;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class ElbowSubsystem  extends GBSubsystem {
    private final CANSparkMax motor;


    private static ElbowSubsystem instance;


    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public ElbowSubsystem(){
        this.motor = new CANSparkMax(ElbowConstants.ELBOW_ID, CANSparkLowLevel.MotorType.kBrushless);
        motor.getEncoder().setPositionConversionFactor(ElbowConstants.ELBOW_GEAR_RATIO.getDegrees());
        motor.getPIDController().setP(ElbowConstants.ELBOW_P);
        motor.getPIDController().setI(ElbowConstants.ELBOW_I);
        motor.getPIDController().setD(ElbowConstants.ELBOW_D);
        motor.getEncoder().setPosition(ElbowConstants.ELBOW_START_POSITION.getDegrees());
    }

    public static ElbowSubsystem getInstance() {
        if (instance == null) {
            instance = new ElbowSubsystem();
        }
        return instance;
    }

    public void moveElbow(Rotation2d position){
            motor.getPIDController().setReference(
                    position.getDegrees(),
                    CANSparkBase.ControlType.kPosition,
                    0,
                    ElbowConstants.ARM_FEEDFORWARD.calculate(getPosition().getRadians(), getVelocity())
            );

    }

    public void stayAtPosition(){
        moveElbow(getPosition());
    }

    public Rotation2d getPosition(){
        return Rotation2d.fromRotations(motor.getEncoder().getPosition());
    }

    public double getVelocity(){
        return motor.getEncoder().getVelocity();
    }

    public double tolerance(){
        return ElbowConstants.TOLERANCE;
    }

    public boolean isAtPosition(Rotation2d target){
        return Math.abs(getPosition().getDegrees() - target.getDegrees()) <= ElbowConstants.TOLERANCE;
    }

}
