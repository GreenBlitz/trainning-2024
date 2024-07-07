// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


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
        Bank[] arr1 = {
                Bank.Ratio, Bank.Ratio, Bank.Plus
        };
        Bank[] arr2 = {
                Bank.Ratio, Bank.Ratio, Bank.Ratio
        };
        System.out.println(lowestRisk(Bank.values()));
        System.out.println(lowestRisk(arr1));
        System.out.println(lowestRisk(arr2));
    }
    public static Bank lowestRisk(Bank[] arr) {
        int minRisk = 11;
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
