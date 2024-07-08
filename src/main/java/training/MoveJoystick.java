package training;

import edu.wpi.first.wpilibj2.command.Command;
import training.subsystems.SubsystemOfDOOM;
import utils.joysticks.SmartJoystick;

public class MoveJoystick extends Command {

    private final SubsystemOfDOOM module;
    private SmartJoystick joystick;


    public MoveJoystick(Robot robot, SmartJoystick joystick) {
        module = robot.getModule();
        addRequirements(module);
        this.joystick = joystick;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        module.moveVertical(joystick.getAxisValue(SmartJoystick.Axis.LEFT_Y) * 0.6);
        module.moveHorizontal(joystick.getAxisValue(SmartJoystick.Axis.RIGHT_X) * 0.6);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        module.stopBoth();
    }


}
