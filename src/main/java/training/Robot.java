package training;

import com.ctre.phoenix6.hardware.TalonFX;
import training.subsystems.Module;

public class Robot {

    private TalonFX motor;

    public Robot() {
        this.motor = new TalonFX(0);
    }

    // Add your subsystems getters...
    public TalonFX getMotor() {
        return motor;
    }
}
