package training.subsystems.RobotArm;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.Logger;
import training.ModuleConstants;
import training.Robot;
import utils.GBSubsystem;
import utils.joysticks.SmartJoystick;

public class RobotArm extends GBSubsystem {

    private CANSparkMax motor;
    private Rotation2d position;

    public RobotArm(){
        this.motor = new CANSparkMax(0, CANSparkLowLevel.MotorType.kBrushless);
        this.position = new Rotation2d();
    }

    public void setPosition(Rotation2d position){
        motor.getPIDController().setReference(position.getRotations(), CANSparkBase.ControlType.kPosition);
    }




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



    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
