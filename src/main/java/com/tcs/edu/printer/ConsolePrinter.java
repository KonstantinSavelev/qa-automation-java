package com.tcs.edu.printer;

import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;

public class ConsolePrinter extends ValidatedService implements Printer {

    private final SeverityDecorator severity = new SeverityDecorator();

    private final TimestampMessageDecorator timestamp = new TimestampMessageDecorator();

    /**
     * Decorating and printing a message
     *
     * @param message DTO, message and severity
     */
    public void print(Message message) {
        if (super.isArgsValid(message)) return;
        System.out.println(timestamp.massageDecorator(message.getBody() + severity.massageDecorator(message.getSeverity())));
    }
}
