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
            if (current != null && current.getBody() != null) {
                System.out.println(TimestampMessageDecorator.decorate(current.getBody() + SeverityDecorator.mapSeverity(current.getSeverity())));
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
                print(messages[counter]);
            }
        } else if (order == MessageOrder.DESC)
            for (int counter = 0; counter <= messages.length - 1; counter++) {
                print(messages[counter]);
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
        Message[] printMessages = new Message[messages.length];

        if (doubling == Doubling.DISTINCT) {
            for (int counter = 0; counter <= messages.length - 1; counter++) {
                if (!checkPrintMessage(messages[counter].getBody(), printMessages)) {
                    printMessages[counter] = new Message(messages[counter].getSeverity(), messages[counter].getBody());
                }
                if (counter == messages.length - 1) {
                    print(order, printMessages);
                }
            }
        } else {
            print(order, messages);
        }
    }


    /**
     * checking if message have been printed
     *
     * @param checkedMassage - string massage
     * @param messages       - array of printed messages
     * @return boolean
     */
    private static boolean checkPrintMessage(String checkedMassage, Message[] messages) {
        for (Message message : messages) {
            if (message != null && Objects.equals(message.getBody(), checkedMassage)) {
                return true;
            }
        }
        return false;
    }
}
