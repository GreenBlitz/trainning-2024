package training.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import training.RobotConstants;
import utils.GBSubsystem;

public class SubsystemOfDOOM extends GBSubsystem {

    private final TalonFX verticalMotor;
    private final TalonFX horizontalMotor;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public SubsystemOfDOOM() {
        verticalMotor = new TalonFX(RobotConstants.ID_OF_VERTICAL_MOTOR);
        horizontalMotor = new TalonFX(RobotConstants.ID_OF_HORIZONTAL_MOTOR);
    }

    public void moveVertical(double power) {
        verticalMotor.set(power);
    }

    public void moveHorizontal(double power) {
        horizontalMotor.set(power);
    }

    public void moveBoth(double power) {
        horizontalMotor.set(power);
        verticalMotor.set(power);
    }


    public void stopVertical() {
        verticalMotor.set(0);
    }

    public void stopHorizontal() {
        horizontalMotor.set(0);
    }

    public void stopBoth() {
        horizontalMotor.set(0);
        verticalMotor.set(0);
    }
}
