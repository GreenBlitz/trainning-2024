package subsystems.wrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class WristConstants {

	protected static final int MOTOR_ID = 11;

	protected static final TalonSRXControlMode PID_CONTROL_MODE = TalonSRXControlMode.Position;

	protected static final int SINGLE_ROTATION = 1;

	protected static final int FULL_CIRCLE_ENCODER_TICKS = 168;

}
