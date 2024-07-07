public class Dog extends Animal {
    @Override
    public String speak() {
        return "havhavhav";
    }

    @Override
    public double distFromHome() {
        // Dog always misses his home
        return Double.POSITIVE_INFINITY;
    }
}
