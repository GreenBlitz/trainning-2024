package frc;
public final class Main {

    private Main() {}

    public static void checkBank(Bank[] banks){

        int min = 11;
        int place = 0;

        for (int i = 0; i < banks.length; i++) {
            if (banks[i].risk < min) {
                min = banks[i].risk;
                place = i;
            }
        }

        System.out.println("The bank with the least risk is " + banks[place].name());
    }

    public static void main(String... args) {

        Bank[] banks = new Bank[]{Bank.CAMODIA, Bank.DJIOUTI, Bank.EQUATORIAL_GUINEA};
        checkBank(banks);

    }

}
