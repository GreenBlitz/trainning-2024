package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import utils.GBSubsystem;
import utils.simulation.SingleJointedArmSimulation;

import static training.Elbow.ElbowConstants.*;

public class SimulationElbow implements IElbow {
    private final SingleJointedArmSimulation arm;

    public SimulationElbow() {
        this.arm = new SingleJointedArmSimulation(new SingleJointedArmSim(ELBOW_GEARBOX, ELBOW_GEARING, SingleJointedArmSim.estimateMOI(ELBOW_LENGTH_METERS, ELBOW_MASS), ELBOW_LENGTH_METERS, ELBOW_MINIMUM_ANGLE.getRadians(), ELBOW_MAXIMUM_ANGLE.getRadians(), true, 0));
    }

    @Override
    public Rotation2d getCurrentAngle() {
        return arm.getPosition();
    }

    @Override
    public Rotation2d getCurrentVelocity() {
        return arm.getVelocity();
    }

    @Override
    public void updateAngle(Rotation2d targetAngle) {
        double target = targetAngle.getRotations() % 1;
        double FFValue = ELBOW_FEEDFORWARD.calculate(getCurrentAngle().getRadians(), arm.getVelocity().getRadians());

        arm.setPower(Controller.calculate(target, targetAngle.getRadians()) + FFValue);
    }
}
