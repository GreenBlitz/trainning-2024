package training.Elbow.NeoElbow;

import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;

public class NeoElbowConstants {

	protected static final int ID = 0;

	protected static final CANSparkLowLevel.MotorType MOTOR_TYPE = CANSparkLowLevel.MotorType.kBrushless;


	protected static final PIDController PID_CONTROLLER = new PIDController(0, 0, 0);

	protected static final ArmFeedforward FEEDFORWARD = new ArmFeedforward(0, 0, 0, 0); // Keep kV and kA 0


	protected static final double ELBOW_GEAR_RATIO = (double) 250 / 7;

	protected static final double MAXIMUM_POWER_LIMIT = 0.9;

	protected static final double MINIMUM_POWER_LIMIT = -0.9;


	protected static final int POSITION_PID_SLOT = 0;


	protected static final Rotation2d BACKWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(-81);

	protected static final Rotation2d FORWARD_ANGLE_LIMIT = Rotation2d.fromDegrees(90);

}
