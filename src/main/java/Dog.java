public class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void sayName() {
        System.out.println("Bark " + getName());
    }

    @Override
    public void eat() {

    }
}
