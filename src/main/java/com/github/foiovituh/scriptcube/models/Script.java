package com.github.foiovituh.scriptcube.models;

import com.github.foiovituh.scriptcube.utils.Warner;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class Script {
    private final File file;
    private int exitValue;
    private LocalTime timeOfLastExecution;
    private static final String SH_FILE_EXTENSION = ".sh";

    public Script(String filePath) {
        file = new File(filePath);
        final String fileName = file.getName();
        
        if (file.exists() && !fileName.endsWith(SH_FILE_EXTENSION)) {
            Warner.mustToBeShFile(fileName);
        }
    }

    public File getFile() {
        return file;
    }
        
    public int getExitValue() {
        return exitValue;
    }
    
    public LocalTime getTimeOfLastExecution() {
        return timeOfLastExecution;
    }

    public void execute() {
        final Process process = startProcess();
        
        try {
            exitValue = process.waitFor();
        } catch (InterruptedException interruptedException) {
            Warner.exceptionMessage(interruptedException);
        }
    }
    
    private Process startProcess() {
        final ProcessBuilder processBuilder = new ProcessBuilder(
            file.getAbsolutePath()
        );

        Process process = null;
        processBuilder.inheritIO();
                
        try {
            process = processBuilder.start();
            timeOfLastExecution = LocalTime.now();
        } catch (IOException ioException) {
            Warner.exceptionMessage(ioException);
        }
        
        return process;
    }

    @Override
    public String toString() {
        return "\nscript: ".concat(file.toString())
            .concat("\ntimeOfLastExecution: ")
            .concat(timeOfLastExecution + "\n");
    }
}
