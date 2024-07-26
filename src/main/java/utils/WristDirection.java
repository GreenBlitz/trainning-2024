package utils;

public enum WristDirection {
    kUp(1), kDown(-1);

    private int val;

    WristDirection(int val) {
        this.val = val;
    }

    public int toInt() {
        return this.val;
    }
}
