package training.subsystems.Arm.Roller;

import utils.GBSubsystem;

public class Roller extends GBSubsystem {
    private final IRoller roller;

    public Roller() {
        roller = RollerFactory.create();
    }

    @Override
    protected String getLogPath() {
        return "";
    }

    @Override
    protected void subsystemPeriodic() {

    }


    public void setVelocity(double velocity) {
        roller.setVelocity(velocity);
    }

    public void stopMotor() {
        roller.stopMotor();
    }

}
