public enum Bank {
    BANK1(1),
    BANK2(7),
    BANK3(6);

    private int value;

    Bank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
