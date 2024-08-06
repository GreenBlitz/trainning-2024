package training.subsystems.ArmSubsystems.elbowSubsystem.simulationElbow;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import training.RobotConstants;
import training.subsystems.ArmSubsystems.elbowSubsystem.ElbowInputsAutoLogged;
import training.subsystems.ArmSubsystems.elbowSubsystem.IElbow;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.subsystems.ArmSubsystems.elbowSubsystem.ElbowConstants;

public class SimulationElbow implements IElbow {

    private SingleJointedArmSim motor;
    private static SimulationElbow instance;
    private PIDController PIDController;
    private ArmFeedforward feedForwardControler;

    private double appliedVoltage;

    private SimulationElbow() {
        this.motor = new SingleJointedArmSim(
                DCMotor.getNEO(1),
                ElbowConstants.ELBOW_GEAR_RATIO.getDegrees(),
                SingleJointedArmSim.estimateMOI(ElbowConstants.ARM_LENGTH, ElbowConstants.ARM_MASS_KG),
                ElbowConstants.ARM_LENGTH,
                ElbowConstants.BACKWARD_ANGLE_LIMIT.getRadians(),
                ElbowConstants.FORWARD_ANGLE_LIMIT.getRadians(),
                false,
                ElbowConstants.PresetPositions.STARTING.ANGLE.getRadians()
        );

        PIDController = ElbowConstants.PIDController;
        feedForwardControler = ElbowConstants.FEEDFORWARD_CONTROLER;
    }

    public static SimulationElbow getInstance() {
        if (instance == null) {
            instance = new SimulationElbow();
        }
        return instance;
    }

    public void setVoltage(double voltage) {
        appliedVoltage = MathUtil.clamp(voltage, -RobotConstants.MAX_MOTOR_VOLTAGE, RobotConstants.MAX_MOTOR_VOLTAGE);
        motor.setInputVoltage(appliedVoltage);
    }

    public void setPower(double power) {
        setVoltage(power * RobotConstants.MAX_MOTOR_VOLTAGE);
    }

    public void goToPosition(Rotation2d targetPosition) {
        setVoltage(
                PIDController.calculate(getPosition().getDegrees(), targetPosition.getDegrees())
                        + feedForwardControler.calculate(getPosition().getDegrees(), targetPosition.getDegrees())
        );
    }

    @Override
    public void updateInputs(ElbowInputsAutoLogged inputs) {
        inputs.velocity = Rotation2d.fromRadians(motor.getVelocityRadPerSec());
        inputs.current = motor.getCurrentDrawAmps();
        inputs.position = Rotation2d.fromRadians(motor.getAngleRads());
    }

    public Rotation2d getPosition() {
        return Rotation2d.fromRadians(motor.getAngleRads());
    }

    public double getVelocity() {
        return motor.getVelocityRadPerSec();
    }

    public boolean isAtTargetAngle(Rotation2d targetAngle, Rotation2d tolerance) {
        return (Math.abs(getPosition().minus(targetAngle).getDegrees()) <= tolerance.getDegrees());
    }

}