package training.subsystems.roller;

public interface IRoller {
    void stop();
    Roller getInstance();
    void goToSpeed(double targetSpeed);
    boolean isAtVelocity(double targetVelocity);
    void init();
}
