package training.subsystems.wrist;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.elbow.ElbowConstants;
import training.subsystems.roller.Roller;
import training.subsystems.roller.RollerConstants;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

    private static CANSparkMax motor;
    private static Wrist instance;

    private Wrist() {
        motor = new CANSparkMax(WristConstant.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
        motor.getPIDController().setP(WristConstant.MOTOR_P);
        motor.getPIDController().setI(WristConstant.MOTOR_I);
        motor.getPIDController().setD(WristConstant.MOTOR_D);
    }

    public static Wrist getInstance() {
        init();
        return instance;
    }

    public static void init() {
        if (instance == null) {
            instance = new Wrist();
        }
    }

    public static void goToAngle(Rotation2d targetAngle) {
        motor.getPIDController().setReference(targetAngle.getDegrees(), CANSparkBase.ControlType.kPosition);
    }

    public boolean isAtAngle(Rotation2d targetAngle) {
        return Math.abs(targetAngle.getDegrees() - motor.getEncoder().getPosition()) == 0;
    }

    public void stop() {
        motor.set(0);
    }


    @Override
    protected String getLogPath() {
        return "Wrist";
    }

    @Override
    protected void subsystemPeriodic() {
    }

}









