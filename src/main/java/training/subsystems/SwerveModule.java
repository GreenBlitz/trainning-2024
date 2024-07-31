package training.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;
public class SwerveModule extends GBSubsystem {

    private static SwerveModule instance;

    private TalonFX linearMotor;

    private TalonFX angularMotor;

    public void stop(){
        linearMotor.set(0);
        angularMotor.set(0);
    }
    public Rotation2d getAngle(){
        return Rotation2d.fromRotations(angularMotor.getPosition().getValue());
    }

    public boolean isItAtAngle(Rotation2d angle){
        return  (Math.abs (getAngle().getDegrees() - angle.getDegrees() ) <= 1);
    }

    private SwerveModule(){
        linearMotor = new TalonFX(4);
        angularMotor = new TalonFX(5);
    }

    public static void init(){
        if (instance == null) {
            instance = new SwerveModule();
        }
    }


    public static SwerveModule getInstance() {
        init();
        return instance;
    }

    public void setVoltageLinear(double voltage) {
        linearMotor.setVoltage(voltage);
    }

    public void setVoltageAngular(double voltage) {
        angularMotor.setVoltage(voltage);
    }


    @Override
    protected String getLogPath() {
        return null;
    }

    @Override
    protected void subsystemPeriodic() {

    }
}
