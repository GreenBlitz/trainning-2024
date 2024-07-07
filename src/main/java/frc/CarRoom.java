package java.frc;

public class CarRoom extends Room{

    public CarRoom(int length, int width, int height, boolean isInside) {
        super(length, width, height, isInside);
    }

    private int openSpace = length * width * height;

    public void addCar(int carWidth, int carLength, int carHeight){
        if (carLength * carHeight * carWidth < openSpace || carHeight * carLength * carWidth == openSpace){
            openSpace -= carHeight * carLength * carWidth;
            System.out.println("Car placed successfully");
        }
        else {
            System.out.println("There's not enough space to place the car in the room");
        }
    }
}
