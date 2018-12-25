package com.github.mujum.aggregate;

import com.github.mujum.current.CurrentHotTest;

public class AggregateEngine {

    /**
     * All aviable modules
     */
    public enum ModulesEnum {
        CurrentTest;
    }

    /**
     * Modules for run
     */
    public static ModulesEnum currentModules[] = {
        ModulesEnum.CurrentTest
    };

    public static void run() {
        for(int index = 0; index < currentModules.length; index++) {
            System.out.println("\n#\nModule: " + currentModules[index].name() + " - started\n#\n#\n#\n#\n");
            switch (currentModules[index]) {
                case CurrentTest:
                    new CurrentHotTest().test();
                    break;
                default:
                    System.out.println("No code for this module");
            }
            System.out.println("\n#\n#\n#\n#\nModule: " + currentModules[index].name() + " - completed\n#\n");
        }
    }
}
