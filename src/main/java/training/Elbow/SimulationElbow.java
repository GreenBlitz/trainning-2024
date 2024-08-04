package training.Elbow;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import utils.GBSubsystem;
import utils.simulation.SingleJointedArmSimulation;

import static training.Elbow.ElbowConstants.*;

public class SimulationElbow extends GBSubsystem implements IElbow {
    private static SimulationElbow instance;

    public static SimulationElbow getInstance() {
        if (instance == null) {
            instance = new SimulationElbow();
        }
        return instance;
    }

    private final SingleJointedArmSimulation arm;
    private Rotation2d targetAngle;

    private SimulationElbow() {
        this.targetAngle = DEFAULT_POSITION_ELBOW;
        this.arm = new SingleJointedArmSimulation(new SingleJointedArmSim(ELBOW_GEARBOX, ELBOW_GEARING, SingleJointedArmSim.estimateMOI(ELBOW_LENGTH_METERS, ELBOW_MASS), ELBOW_LENGTH_METERS, ELBOW_MIN_ANGLE.getRadians(), ELBOW_MAX_ANGLE.getRadians(), true, 0));
    }

    @Override
    public Rotation2d getTargetAngle() {
        return targetAngle;
    }

    @Override
    public void setTargetAngle(Rotation2d targetAngle) {
        this.targetAngle = targetAngle;
    }

    @Override
    public void addToAngle(Rotation2d angle) {
        this.targetAngle = this.targetAngle.plus(angle);
    }

    @Override
    public void subtractFromAngle(Rotation2d angle) {
        this.targetAngle = this.targetAngle.minus(angle);
    }

    @Override
    public boolean isAtAngle(Rotation2d angle) {
        double anglesDelta = (this.targetAngle.getDegrees() % 360) - (angle.getDegrees() % 360);
        return Math.abs(anglesDelta) <= ELBOW_TOLERANCE_SIM.getDegrees();
    }

    @Override
    protected String getLogPath() {
        return ELBOW_LOG_PATH;
    }

    @Override
    public Rotation2d getCurrentAngle() {
        return arm.getPosition();
    }

    @Override
    public void LockElbowInPlace() {
        targetAngle = getCurrentAngle();
    }

    @Override
    public void subsystemPeriodic() {
        double target = targetAngle.getRotations() % 1;
        double FFValue = ELBOW_FEEDFORWARD.calculate(getCurrentAngle().getRadians(), arm.getVelocity().getRadians());

        arm.setPower(Controller.calculate(target, getTargetAngle().getRadians()) + FFValue);
    }
}
