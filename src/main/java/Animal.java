public abstract class Animal implements IAnimal {
    int x, y, z;
    String type;

    @Override
    public String speak() {
        return "hello";
    }

    @Override
    public void goTo(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        if (z > 0) {
            type = "bird";
        }
    }

    @Override
    public void goHome() {
        x = 0;
        y = 0;
        z = 0;
    }

    @Override
    public double distFromHome() {
        return Math.pow(x * x + y * y + z * z, 0.5);
    }
}
