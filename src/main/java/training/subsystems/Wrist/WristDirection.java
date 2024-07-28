package training.subsystems.Wrist;

public enum WristDirection {
    kLeft(1), kRight(-1);

    private int val;

    WristDirection(int val) {
        this.val = val;
    }

    public int toInt() {
        return this.val;
    }
}
