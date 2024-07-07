package frc;

public class CarRoom extends Room{

    private int openSpace;

    public CarRoom(int length, int width, int height, boolean isInside) {
        super(length, width, height, isInside);
        this.openSpace = length * width * height;
    }

    public void addCar(int carWidth, int carLength, int carHeight){
        if (carLength * carHeight * carWidth <= openSpace){
            openSpace -= carHeight * carLength * carWidth;
            System.out.println("Car placed successfully");
        }
        else {
            System.out.println("There's not enough space to place the car in the room");
        }
    }
}
