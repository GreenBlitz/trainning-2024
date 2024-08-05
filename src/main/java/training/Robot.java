package training;

import training.subsystems.ArmSubsystems.elbowSubsystem.neoElbow.NeoElbow;
import training.subsystems.ArmSubsystems.rollerSubsystem.Roller;
import training.subsystems.ArmSubsystems.wristSubsystem.Wrist;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.pathfinding.LocalADStar;
import com.pathplanner.lib.pathfinding.Pathfinding;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import org.littletonrobotics.junction.LogFileUtil;
import org.littletonrobotics.junction.LoggedRobot;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.NT4Publisher;
import org.littletonrobotics.junction.wpilog.WPILOGReader;
import org.littletonrobotics.junction.wpilog.WPILOGWriter;

public class Robot {

	// Enter your subsystems...

    private final NeoElbow elbow;
    private final Wrist wrist;
    private final Roller roller;

    public Robot() {
        // Boot your subsystems...
        elbow = NeoElbow.getInstance();
        wrist = Wrist.getInstance();
        roller = Roller.getInstance();

    }



    public enum robotType {
        SYNCOPA,
        SIMULATION,
    }


    // Add your subsystems getters...
}