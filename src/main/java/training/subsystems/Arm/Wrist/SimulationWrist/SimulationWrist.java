package training.subsystems.Arm.Wrist.SimulationWrist;

import com.ctre.phoenix6.configs.ClosedLoopGeneralConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.subsystems.Arm.Elbow.ElbowConstants;
import training.subsystems.Arm.Elbow.SimulationElbow.SimulationElbowConstants;
import training.subsystems.Arm.Wrist.WristConstants;
import training.subsystems.Arm.Wrist.IWrist;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationWrist implements IWrist {
    private final SingleJointedArmSimulation motor;
    public SimulationWrist() {
        SingleJointedArmSim elbowSimulation = new SingleJointedArmSim(
                DCMotor.getCIM(SimulationElbowConstants.NUMBER_OF_MOTORS),
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
        ClosedLoopGeneralConfigs a = new ClosedLoopGeneralConfigs();
        a.ContinuousWrap = true;
        motor = new SingleJointedArmSimulation(elbowSimulation);
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration()
                .withSlot0(SimulationElbowConstants.SLOT_0_CONFIGS)
                .withClosedLoopGeneral(a);
        motor.applyConfiguration(talonFXConfiguration);
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
