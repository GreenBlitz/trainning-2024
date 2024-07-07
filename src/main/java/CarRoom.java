public class CarRoom extends Room {
    double emptySpace;
    public CarRoom(double w, double l, double h) {
        super(w, l, h);
        emptySpace = w * l * h;
    }
    public boolean insertCar(double volume) {
        if (emptySpace >= volume) {
            emptySpace -= volume;
            return true;
        }
        return false;
    }
}
