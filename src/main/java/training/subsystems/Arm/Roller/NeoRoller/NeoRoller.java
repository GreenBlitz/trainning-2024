package training.subsystems.Arm.Roller.NeoRoller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.subsystems.Arm.Roller.RollerConstants;
import training.subsystems.Arm.Roller.IRoller;
import utils.GBSubsystem;

public class NeoRoller implements IRoller {


    private final CANSparkMax motor;

    public NeoRoller() {
        this.motor = new CANSparkMax(RollerConstants.MOTOR_ID, CANSparkLowLevel.MotorType.kBrushless);
        motor.getEncoder().setPositionConversionFactor(RollerConstants.POSITION_CONVERSION_FACTOR);
        motor.getEncoder().setVelocityConversionFactor(RollerConstants.VELOCITY_CONVERSION_FACTOR);
        motor.getEncoder().setPosition(RollerConstants.STARTING_POSITION.getRotations());
    }

    public void setVelocity(double velocity) {
        motor.set(velocity);
    }

    public void stopMotor() {
        motor.stopMotor();
    }

}
