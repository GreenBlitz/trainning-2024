public enum Bank {
    HAPOALIM(0),
    DISCOUNT(10),
    MIZRAHITEFAHOT(5);

    public final int danger_level;

    Bank(int dangerLevel) {
        danger_level = dangerLevel;
    }
}


