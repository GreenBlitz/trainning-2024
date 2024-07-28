package training.subsystems.RobotArm;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.Module;
import utils.GBSubsystem;

public class ElbowSubsystem extends GBSubsystem {

    private CANSparkMax motor;
    private Rotation2d position;


    public ElbowSubsystem(){
        this.motor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);
        this.position = new Rotation2d();
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




    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
