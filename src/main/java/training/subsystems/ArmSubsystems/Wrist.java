package training.subsystems.ArmSubsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

    private final TalonSRX motor;
    private final Rotation2d targetPosition;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public Wrist(){
        this.motor=new TalonSRX(WristConstants.WRIST_ID);
        this.targetPosition= WristConstants.WRIST_STARTING_POSITION;
        motor.configAllSettings(WristConstants.SRX_CONFIG);
    }

    public void moveWrist(double power){
        motor.set(ControlMode.PercentOutput,power);
    }

    public void stopElbow(){
        motor.set(ControlMode.PercentOutput,0);
    }

    public Rotation2d getWristPosition(){
        return Rotation2d.fromRotations(motor.getSelectedSensorPosition());
    }

    public double getWristVelocity(){
        return motor.getSelectedSensorVelocity();
    }

    public boolean isAtTarget(Rotation2d target, Rotation2d tolerance) {
        return Math.abs(getWristPosition().getDegrees() - target.getDegrees()) <= tolerance.getDegrees();
    }
}
