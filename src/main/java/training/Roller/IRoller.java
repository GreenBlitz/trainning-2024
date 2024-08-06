package training.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.*;
import static training.Roller.RollerDirection.kBackward;
import static training.Roller.RollerDirection.kForward;

public interface IRoller {

    void setPower(double power);

    Rotation2d getPosition();

    Rotation2d getVelocity();

    void updateVelocity(Rotation2d targetVelocity, RollerDirection direction);


}

