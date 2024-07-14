package training.subsystems;

import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import training.Robot;
import training.RobotConstants;
import utils.GBSubsystem;

public class SwerveModule extends GBSubsystem {

    private final TalonFX verticalMotor;
    private final TalonFX horizontalMotor;

    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }

    public SwerveModule() {
        verticalMotor = new TalonFX(RobotConstants.ID_OF_VERTICAL_MOTOR);
        horizontalMotor = new TalonFX(RobotConstants.ID_OF_HORIZONTAL_MOTOR);
        horizontalMotor.getConfigurator().apply(new FeedbackConfigs().withSensorToMechanismRatio(150/7));
        horizontalMotor.setPosition(0);
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

    public Rotation2d getHorizontalPosition(){
        return Rotation2d.fromRotations(horizontalMotor.getPosition().getValue());
    }

    public Rotation2d getVerticalPosition(){
        return Rotation2d.fromRotations(verticalMotor.getPosition().getValue());
    }

    public double getHorizontalSpeed(){
        return horizontalMotor.getVelocity().getValue();
    }

    public double getVerticalSpeed(){
        return verticalMotor.getVelocity().getValue();
    }

    public boolean searchPosition(Rotation2d position2, double tolerance){
        return getHorizontalPosition().getDegrees() <= position2.getDegrees() + tolerance && getHorizontalPosition().getDegrees() >= position2.getDegrees() - tolerance;
    }
}
