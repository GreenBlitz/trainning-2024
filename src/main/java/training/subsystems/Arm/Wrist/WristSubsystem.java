package training.subsystems.Arm.Wrist;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class WristSubsystem extends GBSubsystem {
    private final TalonSRX motor;
    private final Rotation2d targetPosition;


    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public WristSubsystem(){
        this.motor = new TalonSRX(WristConstants.WRIST_ID);
        this.targetPosition =  WristConstants.WRIST_START_POSITION;
    }

    public void setSpeed(double power){
        motor.set(ControlMode.PercentOutput, power);
    }

    public void stop(){
        motor.set(ControlMode.PercentOutput, 0);
    }

    public Rotation2d getPosition(){
        return Rotation2d.fromRotations(motor.getSelectedSensorPosition());
    }

    public double getSpeed(){
        return motor.getSelectedSensorVelocity();
    }

    public double tolerance(){
        return WristConstants.TOLERANCE;
    }

    public boolean isAtPosition(Rotation2d target){
        return Math.abs(getPosition().getDegrees() - target.getDegrees()) <= WristConstants.TOLERANCE;
    }
}
