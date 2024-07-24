package training.subsystems;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import training.ModuleConstants;
import utils.GBSubsystem;

public class Module extends GBSubsystem {
    private TalonFX linearMotor;
    private TalonFX angularMotor;

    @Override
    protected String getLogPath() {
        return "";
    }


    @Override
    protected void subsystemPeriodic() {
        SmartDashboard.putNumber("Position",angularMotor.getPosition().getValue());
        SmartDashboard.putNumber("goal",angularMotor.getClosedLoopReference().getValue());
    }

    public Module() {
        this.linearMotor = new TalonFX(ModuleConstants.LINEAR_MOTOR_ID);
        this.angularMotor = new TalonFX(ModuleConstants.ANGULAR_MOTOR_ID);
        angularMotor.setPosition(0);
        angularMotor.getConfigurator().apply(new FeedbackConfigs().withSensorToMechanismRatio(ModuleConstants.GEAR_RATIO));
        angularMotor.getConfigurator().apply(ModuleConstants.ANGULAR_MOTOR_SLOT0_CONFIGS);


    }

    public void setAngularMotorByPosition(Rotation2d position) {
        angularMotor.setControl(new PositionVoltage(position.getRotations()));
    }

    public void moveLinearMotor(double power) {
        linearMotor.set(power);
    }

    public void moveAngularMotor(double power) {
        angularMotor.set(power);
    }

    public void stopAngularMotor() {
        angularMotor.set(0);
    }

    public void stopLinearMotor() {
        linearMotor.set(0);
    }

    public void stopBothMotor() {
        linearMotor.set(0);
        angularMotor.set(0);
    }

    public Rotation2d getAngularPosition() {
        return Rotation2d.fromRotations(angularMotor.getPosition().getValue());

    }
}
