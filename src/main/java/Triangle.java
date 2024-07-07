public class Triangle {
    private Point2D a;
    private Point2D b;
    private Point2D c;

    public Triangle(Point2D a, Point2D b, Point2D c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point2D[] getPoints() {
        return new Point2D[]{a, b, c};
    }

    public void setA(Point2D a) {
        this.a = a;
    }

    public void setB(Point2D b) {
        this.b = b;
    }
    public void setC(Point2D c) {
        this.c = c;
    }

    public double area() {
        double s = (a.abs() + b.abs() + c.abs()) / 2;
        return Math.pow(s*(s - a.abs())*(s - b.abs())*(s - c.abs()), 0.5);
    }
}
