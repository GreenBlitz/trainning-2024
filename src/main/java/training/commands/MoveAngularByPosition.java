package training.commands;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import org.littletonrobotics.junction.Logger;
import training.ModuleConstants;
import training.Robot;
import training.subsystems.Module;
import utils.joysticks.Axis;
import utils.joysticks.SmartJoystick;

public class MoveAngularByPosition extends Command {
    private TalonFX motor;
    private Rotation2d position;

    public MoveAngularByPosition(Robot robot, Rotation2d position) {
        this.motor = robot.getMotor();
        this.position = position;
    }

    @Override
    public void execute() {
        motor.setPosition(position.getRotations());
    }

    public void end(boolean interrupted) {
        motor.stopMotor();
    }
}
