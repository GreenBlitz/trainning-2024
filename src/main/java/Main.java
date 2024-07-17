// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {
    public static void checkingBanks(Bank[] banks){
        String nameOfTheBanks = "";
        int max = 11;
        for(int i = 0; i < banks.length; i++) {
            if(banks[i].getValue() < max){
                max = banks[i].getValue();
                nameOfTheBanks = banks[i].name();
            }
        }
        System.out.println(nameOfTheBanks);
    }

    private Main() {}

    /**
     * Main initialization function. Do not perform any initialization here.
     *
     * <p>If you change your main robot class, change the parameter type.
     */
    public static void main(String... args) {
        Bank[] banks = {Bank.BANK1,Bank.BANK2,Bank.BANK3};
        Consumer<Bank[]> functionConsumer = (Bank[] banks1)->checkingBanks(banks1);
        Supplier<Double> example = () -> Math.random() * 100;
        functionConsumer.accept(banks);
        System.out.println(example.get());
        Exception e = new Exception("hi");
    }

}
