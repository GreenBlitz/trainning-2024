package training.subsystems.elbow;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {
    private final CANSparkMax motor;
    private static Elbow instance;

    private Elbow(){
        motor = new CANSparkMax(5, CANSparkLowLevel.MotorType.kBrushless);
        motor.getPIDController().setP(1);
        motor.getPIDController().setI(0);
        motor.getPIDController().setD(0);
    }

    public static void init(){
        if (instance == null) {
            instance = new Elbow();
        }
    }

    public static Elbow getInstance() {
        init();
        return instance;
    }
    public void goToAngel(Rotation2d targetAngle){
        motor.getPIDController().setReference(targetAngle.getDegrees(), CANSparkBase.ControlType.kPosition);
    }

    public boolean isAtAngle(Rotation2d targetAngle){
        return Math.abs(targetAngle.getDegrees() - motor.getEncoder().getPosit
    }



    @Override
    protected String getLogPath() {
        return "Elbow";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
