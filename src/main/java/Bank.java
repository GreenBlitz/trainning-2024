public enum Bank {
    L(2),
    PLUS(5),
    RATIO(10);
    public final int risk;
    Bank(int risk){
        this.risk = risk;
    }
}
