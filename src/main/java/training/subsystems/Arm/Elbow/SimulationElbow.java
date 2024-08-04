package training.subsystems.Arm.Elbow;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import utils.simulation.SingleJointedArmSimulation;

public class SimulationElbow {

    private SingleJointedArmSimulation elbowSimulation;
    private SingleJointedArmSim armSim;
    private PIDController controller;


    public SimulationElbow(){
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
    }

}
