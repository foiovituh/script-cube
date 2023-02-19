package com.github.foiovituh.scriptcube;

import com.github.foiovituh.scriptcube.models.Cube;
import com.github.foiovituh.scriptcube.utils.Warner;

public class ScriptCube {
    private static final String STOP_MODE = "--sm";
    
    public static void main(String[] args) {
        if (args.length == 0) {
            Warner.missingArguments();
        }

        final boolean stopIfExitValueIsNotZero = args.length > 1
                && STOP_MODE.equals(args[1]);

        new Cube(args[0], stopIfExitValueIsNotZero)
                .executeScripts()
                .showHistory();
    }
}
