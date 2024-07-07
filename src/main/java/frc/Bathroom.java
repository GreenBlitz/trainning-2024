package frc;

import java.util.Scanner;

public class Bathroom extends Room{

    private final Scanner reader = new Scanner(System.in);

    public Bathroom(int length, int width, int height, boolean isInside) {
        super(length, width, height, isInside);
    }

    public void isRoomEmpty(){
        System.out.println("Is someone there?");
        boolean empty = reader.hasNext();

        if (empty)
            System.out.println("You can enter");
        else
            System.out.println("You can't enter, there's someone in the room");
    }
}
