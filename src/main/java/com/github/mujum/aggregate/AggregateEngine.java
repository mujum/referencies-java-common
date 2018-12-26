package com.github.mujum.aggregate;

import com.github.mujum.current.CurrentHotTest;

/**
 * @author mujum
 *
 * Модуль, выбирающий какие модули будут запущены
 * и запускающий их через их точку входа
 */
public class AggregateEngine {

    /**
     * All aviable modules
     */
    private enum ModulesEnum {
        CurrentTest;
    }

    /**
     * Modules for run
     */
    private static ModulesEnum currentModules[] = {
        ModulesEnum.CurrentTest
    };

    public static void run() {
        for(int index = 0; index < currentModules.length; index++) {
            System.out.println("\n#\nModule: " + currentModules[index].name() + " - started\n#\n#\n#\n#\n");
            entry(currentModules[index]);
            System.out.println("\n#\n#\n#\n#\nModule: " + currentModules[index].name() + " - completed\n#\n");
        }
    }

    private static void entry(ModulesEnum module) {
        switch (module) {
            case CurrentTest:
                new CurrentHotTest().test();
                break;
            default:
                System.out.println("No code for this module");
        }
    }
}