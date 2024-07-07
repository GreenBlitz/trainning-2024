package java.frc;

public class Room {

    protected int length;
    protected int width;
    protected int height;
    protected boolean isInside;

    public Room(int length, int width, int height, boolean isInside){
        this.width = width;
        this.length = length;
        this.height = height;
        this.isInside = isInside;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public boolean getIsInside(){
        return isInside;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    public void setInside(boolean inside) {
        isInside = inside;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public void intercom(String message){
        System.out.println("Hagay says: " + message);
    }
}
