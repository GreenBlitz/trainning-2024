public enum Bank {
    L(2),
    Plus(5),
    Ratio(10);
    public final int risk;
    Bank(int risk){
        this.risk = risk;
    }
}
