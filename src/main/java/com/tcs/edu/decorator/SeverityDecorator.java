package com.tcs.edu.decorator;

/**
 * Decorator to add a severity
 *
 * @author k.s.savelev
 */
public class SeverityDecorator implements decoratorInterface {

    /**
     * map string severity level
     *
     * @param severity - enum, type severity
     * @return String - level
     */
    public String massageDecorator(Severity severity) {
        switch (severity) {
            case MINOR:
                return "()";
            case REGULAR:
                return "(!)";
            case MAJOR:
                return "(!!!)";
            default:
                return "";
        }
    }

    public String massageDecorator(String message) {
        return null;
    }
}
