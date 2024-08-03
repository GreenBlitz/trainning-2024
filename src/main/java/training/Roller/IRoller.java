package training.Roller;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import utils.GBSubsystem;

import static training.Roller.RollerConstants.*;
import static training.Roller.RollerDirection.kBackward;
import static training.Roller.RollerDirection.kForward;

public interface IRoller {
    double getTargetVelocity();

    void setTargetVelocity(double targetVelocity);

    void runForward();

    void runBackward();

    void stop();
}

