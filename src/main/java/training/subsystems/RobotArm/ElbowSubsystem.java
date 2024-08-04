package training.subsystems.RobotArm;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class ElbowSubsystem extends GBSubsystem {

    private CANSparkMax motor;
    private Rotation2d position;
    private static ElbowSubsystem instance;


    private ElbowSubsystem() {
        this.motor = new CANSparkMax(ElbowConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
        this.position = new Rotation2d();
        motor.getPIDController().setP(ElbowConstants.KP);
        motor.getPIDController().setI(ElbowConstants.KI);
        motor.getPIDController().setD(ElbowConstants.KD);
    }

    public static ElbowSubsystem getInstance() {
        if (instance != null)
            instance = new ElbowSubsystem();
        return instance;
    }

    public void goToPosition(Rotation2d position) {
        motor.getPIDController().setReference(position.getRadians(), CANSparkBase.ControlType.kPosition, ElbowConstants.PID_SLOT,ElbowConstants.ARE_FEED_FORWARDS);
    }

    public Rotation2d getPower() {
        return Rotation2d.fromDegrees(motor.getEncoder().getPosition());
    }


    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
