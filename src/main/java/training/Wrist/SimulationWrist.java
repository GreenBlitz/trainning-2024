package training.Wrist;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.GBSubsystem;

import static training.Wrist.WristConstants.*;

public class SimulationWrist extends GBSubsystem implements IWrist {
    private static SimulationWrist instance;

    public static SimulationWrist getInstance() {
        if (instance == null) {
            instance = new SimulationWrist();
        }
        return instance;
    }

    private final DCMotorSim motor;
    private BaseTalonConfiguration configuration;
    private Rotation2d targetAngle;
    private boolean inTestingMode;

    private SimulationWrist() {
        this.motor = new DCMotorSim(DCMotor.getNEO(1), GEARING, SingleJointedArmSim.estimateMOI(WRIST_LENGTH_METERS, WRIST_MASS_KG));
    }

    @Override
    public void stop() {
        targetAngle = new Rotation2d(0);
        motor.setInputVoltage(0);
    }

    @Override
    public void rotate(WristDirection direction) {
        targetAngle = direction.getValue() == 1 ? WRIST_UPPER_POSITION : WRIST_LOWER_POSITION;
    }

    public Rotation2d getCurrentPosition() {
        return Rotation2d.fromRotations(motor.getAngularPositionRotations());
    }

    public Rotation2d getCurrentVelocity() {
        return Rotation2d.fromRotations(motor.getAngularVelocityRPM());
    }


    /** Don't use this in production code. It's here only for debugging etc.
     */
    @Deprecated
    public void setPowerTestingOnly(double power) {
        inTestingMode = true;
        if (Math.abs(power) >= POWER_LIMIT_WRIST) {
            SmartDashboard.putString("motor is trying to spin in power above MAX_POWER_CIM limit. Reverting to 0.9", "");
        }
        motor.setInputVoltage(power);
    }

    @Override
    public void subsystemPeriodic() {
        if (!inTestingMode) {
            motor.setInputVoltage(WristSimulationController.calculate(getCurrentPosition().getRadians(), getCurrentVelocity().getRotations()));
        }
    }

    @Override
    protected String getLogPath() {
        return WRIST_LOG_PATH;
    }
}
