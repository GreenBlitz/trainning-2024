package training.subsystems.module;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import training.Robot;

public class ModuleCommands {
	
	public static Command pointWheel(Rotation2d angle){
		return new FunctionalCommand(
				() -> Robot.module.moveAngle(angle, 0.2),
				() -> {},
				interrupted -> Robot.module.stopSteer(),
				() -> Robot.module.isItAngle(angle)
		);
	}
	
}
