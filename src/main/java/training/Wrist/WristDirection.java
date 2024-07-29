package training.Wrist;

public enum WristDirection {
    kLeft(1),
    kRight(-1);

    private final int value;

    WristDirection(int val) {
        this.value = val;
    }

    public int getValue() {
        return this.value;
    }
}
