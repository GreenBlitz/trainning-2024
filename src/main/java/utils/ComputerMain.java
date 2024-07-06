package utils;

import java.nio.file.Path;

/**
 *  Unless you know what you are doing, do not rename this file because it's being used elsewhere.
 */
class ComputerMain {

    public static void main(String... args) {
        startComputerPrograms(args);
    }

    private static void startComputerPrograms(String... args) {
        String connectedIP = args[0];
        runKeyboard(connectedIP);
    }

    private static void runKeyboard(String connectedIP) {
        CMDHandler.runPythonClass(Path.of("KeyboardToNetworkTables"), connectedIP);
    }

}
