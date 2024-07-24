package training.subsystems.ArmSubsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

public class Wrist extends GBSubsystem {

    private TalonSRX motor;
    private Rotation2d targetPosition;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public Wrist(){
        this.motor=new TalonSRX(Arm_constants.WRIST_ID);
        this.targetPosition=Arm_constants.WRIST_STARTING_POSITION;

    }

    public void moveWrist(double power){
        motor.set(ControlMode.PercentOutput,power);
    }

    public void stopElbow(){
        motor.set(ControlMode.PercentOutput,0);
    }

    public Rotation2d getElbowPosition(){
        return Rotation2d.fromRotations(motor.getSelectedSensorPosition());
    }

    public double getElbowVelocity(){
        return motor.getSelectedSensorVelocity();
    }

    public boolean isAtTarget(Rotation2d target, Rotation2d tolerance) {
        return Math.abs(getElbowPosition().getDegrees() - target.getDegrees()) <= tolerance.getDegrees();
    }
}
