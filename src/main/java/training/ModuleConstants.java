package training;

import com.ctre.phoenix6.configs.Slot0Configs;

public class ModuleConstants {
	public static final double ANGULAR_TOLERANCE = 1.8 / 360;
	public static final Slot0Configs ASS = new Slot0Configs()
			.withKP(45)
			.withKI(0)
			.withKD(0);
	
}
