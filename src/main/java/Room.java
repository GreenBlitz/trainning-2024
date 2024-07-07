public abstract class Room {
    double width;
    double length;
    double height;
    boolean isInside;
    public void enter() {
        isInside = true;
    }
    public void leave() {
        isInside = false;
    }
    public void Intercom(String message) {
        System.out.println(message);
    }
    public Room(double w, double l, double h) {
        width = w;
        length = l;
        height = h;
    }
}
