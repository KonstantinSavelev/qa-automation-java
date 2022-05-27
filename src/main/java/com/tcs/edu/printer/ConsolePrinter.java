package com.tcs.edu.printer;

import com.tcs.edu.decorator.MassageDecorator;
import com.tcs.edu.decorator.SeverityDecorator;
import com.tcs.edu.domain.Message;

public class ConsolePrinter extends ValidatedService implements Printer {

    private final MassageDecorator massageDecorator = new MassageDecorator();
    private final SeverityDecorator severityDecorator = new SeverityDecorator();

    /**
     * Decorating and printing a message
     *
     * @param message DTO, message and severity
     */
    public void print(Message message) {
        if (!super.isArgsValid(message)) return;
        System.out.println(massageDecorator.decorator(message.getBody() + severityDecorator.decorator(message.getSeverity())));
    }
}
