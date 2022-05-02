package com.tcs.edu.printer;

import com.tcs.edu.decorator.*;

import java.util.Objects;

/**
 * API messages service
 *
 * @author k.s.savelev
 */
public class MessageService {

    /**
     * Decorating and printing  a message
     *
     * @param severity - Severity enum, level massage
     * @param messages vararg, text massage
     */
    public static void print(Severity severity, String... messages) {
        for (String current : messages) {
            if (current != null) {
                System.out.println(TimestampMessageDecorator.decorate(current + SeverityDecorator.mapSeverity(severity)));
            }
        }
    }

    /**
     * Decorating, order and printing  a message
     *
     * @param severity - Severity enum, level massage
     * @param order    - MessageOrder enum, type order
     * @param messages vararg, text massage
     */
    public static void print(Severity severity, MessageOrder order, String... messages) {
        if (order == MessageOrder.ASC) {
            for (int counter = messages.length - 1; counter >= 0; counter--) {
                print(severity, messages[counter]);
            }
        } else if (order == MessageOrder.DESC)
            for (int counter = 0; counter <= messages.length - 1; counter++) {
                print(severity, messages[counter]);
            }
    }

    /**
     * Decorating, order, doubling and printing  a message
     *
     * @param severity - Severity enum, level massage
     * @param doubling - Doubling enum, duplication control
     * @param order    - MessageOrder enum, type order
     * @param messages vararg, text massage
     */
    public static void print(Severity severity, MessageOrder order, Doubling doubling, String... messages) {
        String[] printMessages = new String[messages.length];
        System.out.println(order);
        for (int counter = 0; counter <= messages.length - 1; counter++) {
            if (doubling == Doubling.DISTINCT) {
                if (!checkPrintMessage(messages[counter], printMessages)) {
                    print(severity, order, messages[counter]);
                    printMessages[counter] = messages[counter];
                }
            } else {
                print(severity, order, messages[counter]);
            }
        }
    }


    /**
     * checking if message have been printed
     *
     * @param checkedMassage - string massage
     * @param messages       - array of printed messages
     * @return boolean
     */
    private static boolean checkPrintMessage(String checkedMassage, String[] messages) {
        for (String current : messages) {
            if (Objects.equals(current, checkedMassage)) {
                return true;
            }
        }
        return false;
    }
}
