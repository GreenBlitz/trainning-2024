package training.subsystems.Arm.Elbow.SimulationElbow;

import com.ctre.phoenix6.configs.ClosedLoopGeneralConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.subsystems.Arm.Elbow.ElbowConstants;
import training.subsystems.Arm.Elbow.IElbow;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationElbow implements IElbow {

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
        ClosedLoopGeneralConfigs closedLoopGeneralConfigs = new ClosedLoopGeneralConfigs();
        closedLoopGeneralConfigs.ContinuousWrap = true;

        motor = new SingleJointedArmSimulation(elbowSimulation);
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration()
                .withSlot0(SimulationElbowConstants.SLOT_0_CONFIGS)
                .withClosedLoopGeneral(closedLoopGeneralConfigs);
        this.motor.applyConfiguration(talonFXConfiguration);
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
