package training.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import utils.GBSubsystem;

public class Elbow extends GBSubsystem {
    private final TalonFX motor;
    private static Elbow instance;

    private Elbow(){
        motor = new TalonFX(12);
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



    @Override
    protected String getLogPath() {
        return "Elbow";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
