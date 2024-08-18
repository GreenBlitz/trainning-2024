package training.subsystems.Arm.Wrist.SimulationWrist;

import com.ctre.phoenix6.configs.ClosedLoopGeneralConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.subsystems.Arm.Wrist.WristConstants;
import training.subsystems.Arm.Wrist.IWrist;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationWrist implements IWrist {
    private final TalonFX motor;
    public SimulationWrist() {
        motor = new TalonFX(WristConstants.MOTOR_ID);
        ClosedLoopGeneralConfigs closedLoopGeneralConfigs = new ClosedLoopGeneralConfigs();
        closedLoopGeneralConfigs.ContinuousWrap = true;
        TalonFXConfiguration talonFXConfiguration = new TalonFXConfiguration()
                .withSlot0(SimulationWristConstants.SLOT_0_CONFIGS)
                .withClosedLoopGeneral(closedLoopGeneralConfigs);
        motor.getConfigurator().apply(talonFXConfiguration);
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
