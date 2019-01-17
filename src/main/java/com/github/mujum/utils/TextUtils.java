package com.github.mujum.utils;

public class TextUtils {

    /**
     * Управляющие символьные последовательности для управления цветовой схемой
     */
    public enum COLOUR {
        ANSI_RESET, ANSI_BLACK, ANSI_RED, ANSI_GREEN, ANSI_YELLOW,
        ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE;

        String getSequence() {
            switch(this) {
                case ANSI_RESET:    return "\u001B[0m";
                case ANSI_BLACK:    return "\u001B[30m";
                case ANSI_RED:      return "\u001B[31m";
                case ANSI_GREEN:    return "\u001B[32m";
                case ANSI_YELLOW:   return "\u001B[33m";
                case ANSI_BLUE:     return "\u001B[34m";
                case ANSI_PURPLE:   return "\u001B[35m";
                case ANSI_CYAN:     return "\u001B[36m";
                case ANSI_WHITE:    return "\u001B[37m";
                default:            return "";

            }
        }
    }

    public static void printMessageModuleStatus(String message, boolean isBegining) {

        int length = message.length() + (isBegining ? 18 : 20);

        String bigLine = stringRectangleOfSymbol('_', length, 3);
        String smallLine = stringRectangleOfSymbol('#', length, 1);

        if(isBegining) {
            System.out.println(smallLine + "Module: " + coloured(message, COLOUR.ANSI_GREEN) + " - started\n" + bigLine);
        } else {
            System.out.println(bigLine + "Module: " + coloured(message, COLOUR.ANSI_GREEN) + " - completed\n" + smallLine);
        }
    }

    public static String stringRectangleOfSymbol(char symbol, int length, int height) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < length; i++) {
                stringBuilder.append(symbol);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public static String coloured(String string, COLOUR color) {
        return color.getSequence() + string + COLOUR.ANSI_RESET.getSequence();
    }
}