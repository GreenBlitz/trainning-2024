package training.commands;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import training.Robot;
import training.subsystems.Module;
import training.subsystems.RobotArm.ElbowSubsystem;
import utils.joysticks.Axis;
import utils.joysticks.SmartJoystick;

public class MoveAngularMotor extends Command {
    private TalonFX motor;
    private SmartJoystick joystick;

    public MoveAngularMotor(TalonFX motor, SmartJoystick joystick) {
        this.motor = motor;
        this.joystick = joystick;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        motor.set(joystick.getAxisValue(Axis.LEFT_Y) * 0.8);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        motor.stopMotor();

    }

}

