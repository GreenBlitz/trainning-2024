package frc;

public enum Bank {

    CAMODIA(3),
    EQUATORIAL_GUINEA(7),
    DJIOUTI(5);


    public final int risk;

    Bank(int risk) {
        this.risk = risk;
    }
}
