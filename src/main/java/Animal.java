public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name){
    this.name = name;
    this.age = 0;

    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayName() {
        sayName(name);
    }

    public void sayName(String anotherName) {
        System.out.println(anotherName);
    }

    public abstract void eat();
}
