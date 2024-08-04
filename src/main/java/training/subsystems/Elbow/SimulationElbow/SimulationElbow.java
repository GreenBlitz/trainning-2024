package training.subsystems.Elbow.SimulationElbow;

import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.revrobotics.CANSparkBase;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.subsystems.Elbow.ElbowConstants;
import training.subsystems.Elbow.IElbow;
import utils.GBSubsystem;
import utils.simulation.SingleJointedArmSimulation;

import java.util.Map;

public class SimulationElbow extends GBSubsystem implements IElbow {
    private final SingleJointedArmSimulation motor;

    public SimulationElbow() {
        SingleJointedArmSim elbowSimulation = new SingleJointedArmSim(
                DCMotor.getFalcon500(SimulationElbowConstants.NUMBER_OF_MOTORS),
                SimulationElbowConstants.GEAR_RATIO,
                SingleJointedArmSim.estimateMOI(
                        ElbowConstants.ARM_LENGTH,
                        ElbowConstants.ARM_MASS_KG
                ),
                ElbowConstants.ARM_LENGTH,
                ElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
                ElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
                false,
                ElbowConstants.STARTING_POSITION.getRadians());
        motor = new SingleJointedArmSimulation(elbowSimulation);
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration()
                .withFeedback(new FeedbackConfigs().withSensorToMechanismRatio(150/7))
                .withSlot0(SimulationElbowConstants.SLOT_0_CONFIGS);
        motor.applyConfiguration(talonFXConfiguration);
    }
    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {
    }


    public void moveToAngle(Rotation2d position) {
        motor.setControl(new PositionVoltage(position.getRotations()));
    }

    public Rotation2d getPosition() {
        return motor.getPosition();
    }

    public void stopMotor() {
        motor.stop();
    }
}
