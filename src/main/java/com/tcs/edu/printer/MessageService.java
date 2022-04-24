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
            for (int counter = messages.length - 1; counter >= 0; counter--)
                if (messages[counter] != null) {
                    System.out.println(TimestampMessageDecorator.decorate(messages[counter] + SeverityDecorator.mapSeverity(severity)));
                }
        } else if (order == MessageOrder.DESC)
            for (int counter = 0; counter <= messages.length - 1; counter++)
                if (messages[counter] != null) {
                    System.out.println(TimestampMessageDecorator.decorate(messages[counter] + SeverityDecorator.mapSeverity(severity)));
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

        if (order == MessageOrder.ASC) {
            for (int counter = messages.length - 1; counter >= 0; counter--)
                if (messages[counter] != null) {
                    if (doubling == Doubling.DISTINCT) {
                        if (!checkPrintMessage(messages[counter], printMessages)) {
                            System.out.println(TimestampMessageDecorator.decorate(messages[counter] + SeverityDecorator.mapSeverity(severity)));
                            printMessages[counter] = messages[counter];
                        }
                    } else {
                        System.out.println(TimestampMessageDecorator.decorate(messages[counter] + SeverityDecorator.mapSeverity(severity)));
                    }
                }

        } else if (order == MessageOrder.DESC)
            for (int counter = 0; counter <= messages.length - 1; counter++)
                if (messages[counter] != null) {
                    if (doubling == Doubling.DISTINCT) {
                        if (!checkPrintMessage(messages[counter], printMessages)) {
                            System.out.println(TimestampMessageDecorator.decorate(messages[counter] + SeverityDecorator.mapSeverity(severity)));
                            printMessages[counter] = messages[counter];
                        }
                    } else {
                        System.out.println(TimestampMessageDecorator.decorate(messages[counter] + SeverityDecorator.mapSeverity(severity)));
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
