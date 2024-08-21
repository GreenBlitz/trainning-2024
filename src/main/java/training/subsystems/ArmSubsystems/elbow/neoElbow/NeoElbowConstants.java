package training.subsystems.ArmSubsystems.elbow.neoElbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;

public class NeoElbowConstants {

	public static final int ID = 5;

	public static final double KP = 1;
	public static final double KI = 0;
	public static final double KD = 0;

	public static final Rotation2d GEAR_RATIO = Rotation2d.fromRotations(1 / (28.0 * (60.0 / 16.0)));

	public static final double KS = 0;
	public static final double KG = 0.3;
	public static final double KV = 0;
	public static final double KA = 0;

	public static final ArmFeedforward ARM_FEEDFORWARD_CONTROLLER = new ArmFeedforward(KS, KG, KV, KA);

}
