package subsystems.wrist.talonWrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

public class TalonWristConstants {

	protected static final int MOTOR_ID = 11;

	protected static final TalonSRXControlMode PID_CONTROL_MODE = TalonSRXControlMode.Position;

	protected static final int FULL_CIRCLE_ENCODER_TICKS = 168;

}
