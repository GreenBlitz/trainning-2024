package training.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

    private CANSparkMax motor;
    private static Roller instance;

    private Roller(){
        motor = new CANSparkMax(22, CANSparkLowLevel.MotorType.kBrushless);
    }

    public static void init(){
        if (instance == null) {
            instance = new Roller();
        }
    }

    public static Roller getInstance() {
        init();
        return instance;
    }
    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

}
