package training.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {
    private TalonSRX motor;
    private static Wrist instance;

    private Wrist(){
        motor = new TalonSRX(11);
    }

    public static void init(){
        if (instance == null) {
            instance = new Wrist();
        }
    }

    public static Wrist getInstance() {
        init();
        return instance;
    }

    @Override
    protected String getLogPath() {
        return "Wrist";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
