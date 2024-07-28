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
    private Module module;

    public WristSubsystem(){
        this.motor = new TalonSRX(0);
        this.position = new Rotation2d();
        this.module = new Module();
    }


    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
