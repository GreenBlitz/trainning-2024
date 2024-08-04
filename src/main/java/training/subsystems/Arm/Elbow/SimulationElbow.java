package training.subsystems.Arm.Elbow;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.PositionVoltage;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationElbow implements IElbow {

    private SingleJointedArmSimulation elbowSimulation;
    private SingleJointedArmSim armSim;
    private PIDController controller;
    private TalonFXConfiguration config;


    public SimulationElbow() {
        armSim = new SingleJointedArmSim(
                DCMotor.getFalcon500(ElbowConstants.NUMBER_OF_MOTORS),
                ElbowConstants.GEAR_RATIO,
                SingleJointedArmSim.estimateMOI(
                        ElbowConstants.ARM_LENGTH,
                        ElbowConstants.ARM_MASS_KG
                ),
                ElbowConstants.ARM_LENGTH,
                ElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
                ElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
                false,
                ElbowConstants.PresetPositions.STARTING.ANGLE.getRadians()
        );
        controller = new PIDController(ElbowConstants.ELBOW_P, ElbowConstants.ELBOW_I, ElbowConstants.ELBOW_D);
        elbowSimulation = new SingleJointedArmSimulation(armSim);
        config = new TalonFXConfiguration();
        config.Slot0.kP = controller.getP();
        config.Slot0.kI = controller.getI();
        config.Slot0.kD = controller.getD();
        elbowSimulation.applyConfiguration(config);
    }


    @Override
    public void setPower(double power) {
        elbowSimulation.setPower(power);
    }

    @Override
    public void moveElbowToPosition(Rotation2d targetPosition) {
        elbowSimulation.setControl(new PositionVoltage(targetPosition.getRotations()));
    }

    @Override
    public void stayAtPosition() {
        moveElbowToPosition(getPosition());
    }

    @Override
    public Rotation2d getPosition() {
        return elbowSimulation.getPosition();
    }

    @Override
    public Rotation2d getVelocity() {
        return elbowSimulation.getVelocity();
    }

    @Override
    public boolean isAtPosition(Rotation2d target) {
        return Math.abs(elbowSimulation.getPosition().getDegrees() - target.getDegrees()) <= ElbowConstants.TOLERANCE;
    }

}
