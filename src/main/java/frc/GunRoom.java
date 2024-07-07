package java.frc;

public class GunRoom extends Room{

    public GunRoom(int length, int width, int height, boolean isInside) {
        super(length, width, height, isInside);
    }


    public String encrypt(String message){
        message = "this-message-is-encrypted";
        return message;

    }

}
