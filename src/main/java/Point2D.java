public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void getY() {
        this.y = y;
    }

    public int setY(int y) {
        return y;
    }

    public double abs() {
        return Math.pow(x * x + y * y, 0.5);
    }


}
