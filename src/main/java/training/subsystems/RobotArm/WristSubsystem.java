package training.subsystems.RobotArm;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.Module;
import utils.GBSubsystem;

public class WristSubsystem extends GBSubsystem {
    private TalonSRX motor;
    private Rotation2d position;
    private static WristSubsystem instance;
    private WristSubsystem() {
        this.motor = new TalonSRX(WristConstans.MOTOR_ID);
        this.position = new Rotation2d();
        motor.configAllSettings(WristConstans.TALON_SRX_CONFIGURATION);
    }
    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
