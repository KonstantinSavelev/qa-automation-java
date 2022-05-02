package com.tcs.edu.printer;

import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;

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
     * @param messages DTO, message and severity
     */
    public static void print(Message... messages) {
        for (Message current : messages) {
            if (current.getBody() != null) {
                System.out.println(TimestampMessageDecorator.decorate(current.getBody() + SeverityDecorator.mapSeverity(current.getSeverity())));
            } else if (current.getBodies() != null) {
                for (int counter = 0; counter <= current.getBodies().length - 1; counter++) {
                    System.out.println(TimestampMessageDecorator.decorate(current.getBodies()[counter] + SeverityDecorator.mapSeverity(current.getSeverity())));
                }
            }

        }
    }

    /**
     * Decorating, order and printing  a message
     *
     * @param order    - MessageOrder enum, type order
     * @param messages DTO, message and severity
     */
    public static void print(MessageOrder order, Message... messages) {
        if (order == MessageOrder.ASC) {
            for (int counter = messages.length - 1; counter >= 0; counter--) {
                if (messages[counter].getBody() != null) {
                    print(messages[counter]);
                } else if (messages[counter].getBodies() != null) {
                    for (int counterBody = messages[counter].getBodies().length - 1; counterBody >= 0; counterBody--) {
                        print(new Message(messages[counter].getSeverity(), messages[counter].getBodies()[counterBody]));
                    }
                }
            }
        } else if (order == MessageOrder.DESC)
            for (int counter = 0; counter <= messages.length - 1; counter++) {
                if (messages[counter].getBody() != null) {
                    print(messages[counter]);
                } else if (messages[counter].getBodies() != null) {
                    for (int counterBody = 0; counterBody <= messages[counter].getBodies().length - 1; counterBody++) {
                        print(new Message(messages[counter].getSeverity(), messages[counter].getBodies()[counterBody]));
                    }
                }
            }
    }

    /**
     * Decorating, order, doubling and printing  a message
     *
     * @param doubling - Doubling enum, duplication control
     * @param order    - MessageOrder enum, type order
     * @param messages DTO, message and severity
     */
    public static void print(MessageOrder order, Doubling doubling, Message... messages) {
        String[] printMessages = new String[messages.length];
        for (int counter = 0; counter <= messages.length - 1; counter++) {
            if (doubling == Doubling.DISTINCT) {
                if (!checkPrintMessage(messages[counter].getBody(), printMessages)) {
                    printMessages[counter] = messages[counter].getBody();
                }
                if (counter == messages.length - 1) {
                    print(order, new Message(messages[counter].getSeverity(), printMessages));
                }
            } else {
                print(order, messages[counter]);
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
