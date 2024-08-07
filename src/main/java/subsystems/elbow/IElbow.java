package subsystems.elbow;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IElbow {

	public Rotation2d getAngle();

	public double getRPMVelocity();

	public void setPower(double power);

	public void goToPosition(Rotation2d position);

}
