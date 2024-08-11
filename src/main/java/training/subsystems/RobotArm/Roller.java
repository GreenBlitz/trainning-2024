package training.subsystems.RobotArm;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Roller extends GBSubsystem {

	private CANSparkMax motor;
	private static Roller instance;

	private Roller() {
		this.motor = new CANSparkMax(RolerConstens.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
		motor.getPIDController().setP(RolerConstens.KP);
		motor.getPIDController().setI(RolerConstens.KI);
		motor.getPIDController().setD(RolerConstens.KD);
	}

	public static Roller getInstance() {
		if (instance != null)
			instance = new Roller();
		return instance;
	}

	public void moveAtSpeed(Rotation2d velocity) {
		motor.getPIDController()
			.setReference(
				velocity,
				CANSparkBase.ControlType.kVelocity,
				RolerConstens.PID_SLOT,
				RolerConstens.ARB_FEED_FOWORDS
			);
	}


	public Rotation2d getPower() {
		return Rotation2d.fromDegrees(motor.getEncoder().getPosition());
	}
	public boolean isAtSpeed(Rotation2d velocity){
		return (getPower()==velocity);
	}

	protected String getLogPath() {
		return "";
	}


	protected void subsystemPeriodic() {}

}


//    public void setPosition(Rotation2d position){
//        motor.getPIDController().setReference(position.getRotations(), CANSparkBase.ControlType.kPosition);
//
//    }


//    @Override
//    public boolean isFinished() {
//        return Math.abs(module.getAngularPosition().getDegrees() - position.getDegrees()) <= ModuleConstants.ANGULAR_TOLERANCE.getDegrees();
//    }
//
//    @Override
//    public void end(boolean interrupted) {
//        module.stopAngularMotor();
//        Logger.recordOutput("Angular position of module",module.getAngularPosition());
//    }

