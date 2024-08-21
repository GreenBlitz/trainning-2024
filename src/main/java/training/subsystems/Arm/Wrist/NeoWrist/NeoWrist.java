package training.subsystems.Arm.Wrist.NeoWrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.controls.PositionVoltage;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.Arm.Wrist.IWrist;
import training.subsystems.Arm.Wrist.WristConstants;

import javax.swing.text.Position;

public class NeoWrist implements IWrist {

    private final TalonSRX motor;

    public NeoWrist() {
        this.motor = new TalonSRX(NeoWristConstants.MOTOR_ID);
        motor.config_kP(0, WristConstants.KP);
        motor.config_kI(0, WristConstants.KI);
        motor.config_kD(0, WristConstants.KD);
    }

    public void moveToAngle(Rotation2d position) {
        motor.set(TalonSRXControlMode.Position, position.getRotations() * NeoWristConstants.GEAR_RATIO);
    }

    public Rotation2d getPosition() {
        return Rotation2d.fromRotations(motor.getSelectedSensorPosition(NeoWristConstants.MOTOR_ID));
    }

    public void stopMotor() {
        motor.set(TalonSRXControlMode.PercentOutput, 0);
    }
}
