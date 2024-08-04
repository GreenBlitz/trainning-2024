package training.subsystems.Arm.Wrist;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


public class WristSubsystem extends GBSubsystem {
    private final TalonSRX motor;
    private final Rotation2d targetPosition;
    private static WristSubsystem instance;


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
        motor.configAllSettings(WristConstants.TALON_SRX_CONFIG);
        motor.configSelectedFeedbackSensor(
                FeedbackDevice.CTRE_MagEncoder_Relative,
                WristConstants.PID_SLOT,
                WristConstants.TIMEOUT_FOR_CONFIG_SET
        );    }

    public static WristSubsystem getInstance() {
        if (instance == null) {
            instance = new WristSubsystem();
        }
        return instance;
    }

    public void goTo(Rotation2d targetPosition){
        motor.selectProfileSlot(WristConstants.PID_SLOT,0);
        motor.set(ControlMode.Position, targetPosition.getRotations());
    }

    public void setVelocity(double power){
        motor.set(ControlMode.PercentOutput, power);
    }

    public void stop(){
        this.setVelocity(0);
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
