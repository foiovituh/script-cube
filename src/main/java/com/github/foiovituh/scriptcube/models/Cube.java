package com.github.foiovituh.scriptcube.models;

import com.github.foiovituh.scriptcube.utils.Warner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cube {
    private String name;
    private final boolean stopIfExitValueIsNotZero;
    private final List<Script> scripts = new ArrayList<>();
    
    public Cube(String name, boolean stopIfExitValueIsNotZero) {
        this.name = name;
        this.stopIfExitValueIsNotZero = stopIfExitValueIsNotZero;
        
        readCubeFile(name);
    }

    public String getName() {
        return name;
    }

    public List<Script> getScripts() {
        return scripts;
    }
    
    public boolean getStopIfExitValueIsNotZero() {
        return stopIfExitValueIsNotZero;
    }
    
    public Cube executeScripts() {
        for (Script script : scripts) {
            script.execute();
            
            if (stopIfExitValueIsNotZero && script.getExitValue() != 0) {
                break;
            }
        }
        
        return this;
    }

    public void showHistory() {
        System.out.println("\ncube: " + getName());
        
        getScripts().stream()
                .map(Script::toString)
                .forEach(System.out::print);
    }
    
    private void readCubeFile(String path) {
        try {
            final Scanner scanner = new Scanner(new File(path));
            
            while (scanner.hasNextLine()) {
                final String nextLine = scanner.nextLine();
                
                if (nextLine.isBlank()) {
                    continue;
                }
                
                scripts.add(new Script(nextLine));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            Warner.exceptionMessage(fileNotFoundException);
        }
    }
    
    @Override
    public String toString() {
        return "\ncube: ".concat(name)
            .concat("\nstopIfExitValueIsNotZero: ")
            .concat(String.valueOf(stopIfExitValueIsNotZero));
    }
}
