package training.subsystems.arm.elbow;

import training.Robot;

public class ElbowFactory {
	public static IElbow create(){
		return  switch (Robot.ROBOT_TYPE){
			case Real -> new NEOElbow();
			case Simulation ->  new SimulationElbow();
		}
	}
}
