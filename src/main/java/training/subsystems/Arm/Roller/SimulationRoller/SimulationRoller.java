package training.subsystems.Arm.Roller.SimulationRoller;

import com.ctre.phoenix6.configs.ClosedLoopGeneralConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import training.Robot;
import training.subsystems.Arm.Elbow.ElbowConstants;
import training.subsystems.Arm.Elbow.SimulationElbow.SimulationElbowConstants;
import training.subsystems.Arm.Roller.IRoller;
import training.subsystems.Arm.Roller.RollerConstants;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationRoller implements IRoller {
    private final DCMotorSim motor;

    public SimulationRoller() {
        motor = new DCMotorSim(DCMotor.getNEO(SimulationRollerConstants.NUMBER_OF_MOTORS),
                SimulationRollerConstants.GEAR_RATIO,
                SimulationRollerConstants.MOMENT_OF_INERTIA);
    }

    public void setVelocity(double velocity) {
        motor.setInputVoltage(velocity * Robot.BATTERY_VOLTAGE);
    }

    public void stopMotor() {
        setVelocity(0);
    }
}
