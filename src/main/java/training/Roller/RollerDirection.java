package training.Roller;

public enum RollerDirection {
    kForward(1),
    kBackward(-1);

    private final int value;

    RollerDirection(int val) {
        this.value = val;
    }

    public int toInt() {
        return this.value;
    }
}
