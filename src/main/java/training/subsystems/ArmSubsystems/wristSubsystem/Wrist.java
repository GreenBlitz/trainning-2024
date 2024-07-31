package training.subsystems.ArmSubsystems.wristSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

    private final TalonSRX motor;
    private final Rotation2d targetPosition;
    private static Wrist instance;

    private Wrist() {
        this.motor = new TalonSRX(WristConstants.WRIST_ID);
        this.targetPosition = WristConstants.WRIST_STARTING_POSITION;
        motor.configAllSettings(WristConstants.TALON_SRX_CONFIG);
        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    }

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {
        SmartDashboard.putNumber("position",5);
    }
    

    public static Wrist getInstance() {
        if (instance == null) {
            instance = new Wrist();
        }
        return instance;
    }

    public void goToPosition(Rotation2d targetPosition) {
        motor.selectProfileSlot(WristConstants.PID_SLOT,0);
        motor.set(ControlMode.Position, targetPosition.getRotations()*WristConstants.MAG_ENCODER_CONVERSION_FACTOR);
    }
    
    public void setPower(double powerMotor){
        motor.set(ControlMode.PercentOutput,powerMotor);
    }

    public void stopMotor() {
        this.setPower(0);
    }

    public Rotation2d getPosition() {
        return Rotation2d.fromRotations(motor.getSelectedSensorPosition());
    }

    public double getVelocity() {
        return motor.getSelectedSensorVelocity();
    }

    public boolean isAtTargetAngle(Rotation2d targetAngle, Rotation2d tolerance) {
        return (Math.abs(getPosition().minus(targetAngle).getDegrees()) <= tolerance.getDegrees());
    }
}
