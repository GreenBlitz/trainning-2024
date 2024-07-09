// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {

    private Main() {}

    public static void main(String... args) {
        System.out.println(findOptimalBankToRobber());
        SuppliersAndCunsumers();
        exceptionsTryAndCatch();
    }

    public static Bank findOptimalBankToRobber() {
        Bank output;
        output = Bank.HAPOALIM;

        for (Bank bank: Bank.values()) {
            if (output.danger_level >= bank.danger_level) {
                output = bank;
            }
        }

        return output;
    }
    public static void SuppliersAndCunsumers() {
        Random rand = new Random();
        Supplier<Integer> getRandomNumber = () -> rand.nextInt(1, 42);
        Consumer<Integer> printInteger = (Integer Something) -> System.out.println(Something);

        printInteger.accept(getRandomNumber.get());
    }

    public static void exceptionsTryAndCatch() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int input = scanner.nextInt();
            if (input == 45) {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    // Do nothing
                }
            }
            if (input == 100) {
                throw new RuntimeException();
            }
        }
    }
}
