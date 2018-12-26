package com.github.mujum;

import com.github.mujum.aggregate.AggregateEngine;

/**
 * @author mujum
 *
 * Точка входа в приложение, запускает модуль,
 * выбирающий и запускающий различные тесты
 */
public class EntryPoint {
    public static void main(String[] args) {
        AggregateEngine.run();
    }
}