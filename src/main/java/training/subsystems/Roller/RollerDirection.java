package training.subsystems.Roller;

public enum RollerDirection {
    kForward(1), kBackward(-1);

    private int val;

    RollerDirection(int val) {
        this.val = val;
    }

    public int toInt() {
        return this.val;
    }
}
