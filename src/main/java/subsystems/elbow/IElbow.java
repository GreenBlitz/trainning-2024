package subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	public Rotation2d getAngle();

	public Rotation2d getVelocity();

	public void setPower(double power);

	public void goToPosition(Rotation2d position);

}
