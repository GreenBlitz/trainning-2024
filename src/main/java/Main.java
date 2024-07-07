// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import java.util.Scanner;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {

    private Main() {}

    /**
     * Main initialization function. Do not perform any initialization here.
     *
     * <p>If you change your main robot class, change the parameter type.
     */
    public static void main(String... args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            try {
                if(n == 45)
                    throw new IllegalAccessException();
                if(n == 100)
                    throw new RuntimeException();
            } catch (IllegalAccessException e) {
                System.out.println("GOTTEM");
            }
        }
    }
    public static Bank lowestRisk(Bank[] arr) {
        if(arr.length == 0)
            return null;
        int minRisk = arr[0].risk;
        Bank minRiskBank = arr[0];
        for (Bank bank : arr) {
            if (bank.risk < minRisk) {
                minRiskBank = bank;
                minRisk = bank.risk;
            }
        }
        return minRiskBank;
    }



}
