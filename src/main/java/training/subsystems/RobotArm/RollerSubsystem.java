package training.subsystems.RobotArm;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class RollerSubsystem extends GBSubsystem {
    private CANSparkMax motor;
    private Rotation2d position;
    private static RollerSubsystem instance;

    private RollerSubsystem() {
        this.motor = new CANSparkMax(RolerConstens.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
        this.position = new Rotation2d();
        motor.getPIDController().setP(ElbowConstants.KP);
        motor.getPIDController().setI(ElbowConstants.KI);
        motor.getPIDController().setD(ElbowConstants.KD);
    }
    public static RollerSubsystem getInstance() {
        if (instance != null)
            instance = new RollerSubsystem();
        return instance;
    }

    public void goToPosition(Rotation2d position) {
        motor.getPIDController().setReference(position.getRadians(), CANSparkBase.ControlType.kPosition, RolerConstens.PID_SLOT,RolerConstens.ARB_FEED_FOWORDS);
    }

    public Rotation2d getPower() {
        return Rotation2d.fromDegrees(motor.getEncoder().getPosition());
    }








    protected String getLogPath() {

        return "";
    }


    protected void subsystemPeriodic() {

    }
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


