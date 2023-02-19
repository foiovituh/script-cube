package com.github.foiovituh.scriptcube.utils;

public final class Warner {
    private static void logAndExit(String message, int exitValue) {
        System.out.println(message);
        System.exit(exitValue);
    }
    
    public static void missingArguments() {
        logAndExit("missing arguments!", 0);
    }
    
    public static void exceptionMessage(Exception exception) {
        logAndExit(exception.getMessage(), 0);
    }
    
    public static void mustToBeShFile(String fileName) {
        logAndExit(fileName + " must to be .sh file", 0);
    }
}
