package com.tcs.edu.printer;

import com.tcs.edu.decorator.Decorator;
import com.tcs.edu.domain.Message;

public class ConsolePrinter extends ValidatedService implements Printer {

    private final Decorator decorator = new Decorator();

    /**
     * Decorating and printing a message
     *
     * @param message DTO, message and severity
     */
    public void print(Message message) {
        if (!super.isArgsValid(message)) return;
        System.out.println(decorator.massageDecorator(message.getBody() + decorator.massageDecorator(message.getSeverity())));
    }
}
