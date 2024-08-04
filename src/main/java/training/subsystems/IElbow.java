package training.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Rotation2d;
import training.ElbowConstants;
import utils.GBSubsystem;

public interface IElbow {


    void moveToAngle(Rotation2d position);

    Rotation2d getPosition();

    void stopMotor();

}
