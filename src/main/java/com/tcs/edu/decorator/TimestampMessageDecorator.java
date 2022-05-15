package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Decorator to add a timestamp
 *
 * @author k.s.savelev
 */
public class TimestampMessageDecorator implements decoratorInterface {

    static Integer PAGE_SIZE = 2;
    static Integer messageCount = 0;

    /**
     * Add timestamp before massage
     *
     * @param message text string
     * @return String
     */
    public String massageDecorator(String message) {
        final var decoratedMessage = String.format("%d %s %s", ++messageCount, Instant.now(), message);

        if (messageCount % PAGE_SIZE == 0) {
            return decoratedMessage + "\n---";
        } else
            return decoratedMessage;
    }

    public String massageDecorator(Severity severity) {
        return null;
    }
}
