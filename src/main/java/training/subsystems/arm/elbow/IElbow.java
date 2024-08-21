package training.subsystems.arm.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	public Rotation2d getCurrentAngle();

	public void setPower(double power);

	public Rotation2d getCurrentVelocity();

	public void moveToAngle(Rotation2d angle);

	public void stayInPlace();

}
