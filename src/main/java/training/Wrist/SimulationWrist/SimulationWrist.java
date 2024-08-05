package training.Wrist.SimulationWrist;

import com.ctre.phoenix.motorcontrol.can.BaseTalonConfiguration;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import training.Roller.SimulationRoller.SimulationRollerConstants;
import training.Wrist.IWrist;

import static training.Wrist.WristConstants.*;

public class SimulationWrist implements IWrist {
    private final DCMotorSim motor;
    private BaseTalonConfiguration configuration;
    private Rotation2d targetAngle;
    private boolean inTestingMode;

    public SimulationWrist() {
        this.motor = new DCMotorSim(DCMotor.getNEO(1), SimulationWristConstants.WRIST_GEARING, SingleJointedArmSim.estimateMOI(SimulationWristConstants.WRIST_LENGTH_METERS, SimulationWristConstants.WRIST_MASS_KG));
    }

    /** Don't use this in production code. It's here only for debugging etc.
     */
    @Deprecated
    public void setPower(double power) {
        inTestingMode = true;
        if (Math.abs(power) >= SimulationWristConstants.POWER_LIMIT_WRIST_SIMULATION) {
            SmartDashboard.putString("motor is trying to spin in power above MAX_POWER_CIM limit. Reverting to 0.9", "");
        }
        motor.setInputVoltage(power);
    }

    @Override
    public void updateAngle(Rotation2d targetAngle) {
        if (!inTestingMode) {
            motor.setInputVoltage(SimulationWristConstants.WRIST_SIMULATION_CONTROLLER.calculate(motor.getAngularPositionRotations(), motor.getAngularVelocityRPM()));
        }
    }

}
