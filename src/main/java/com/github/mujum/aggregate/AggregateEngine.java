package com.github.mujum.aggregate;

import com.github.mujum.current.CurrentHotTest;
import static com.github.mujum.utils.TextUtils.printMessageModuleStatus;

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
            printMessageModuleStatus(currentModules[index].name(), true);
            entry(currentModules[index]);
            printMessageModuleStatus(currentModules[index].name(), false);
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