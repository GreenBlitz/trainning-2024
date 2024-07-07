import java.util.Scanner;

public class Toilet extends Room {
    public Toilet(double w, double l, double h) {
        super(w, l, h);
    }
    @Override
    public void enter() {
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equals("No")) {
            isInside = true;
        }
    }

}
