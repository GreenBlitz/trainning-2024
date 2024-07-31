package subsystems.wrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class WristConstants {

    static final int WRIST_MOTOR_ID = 0; // TODO replace with actual value
    static final TalonSRXControlMode WRIST_PID_CONTROL_MOD =TalonSRXControlMode.Position;
    static final int SINGLE_ROTATION=1;
    static final int FULL_CIRCLE_ENCODER_TICKS=168;
}
