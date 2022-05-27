package com.tcs.edu.decorator;

/**
 * Decorator to add a severity level
 *
 * @author k.s.savelev
 */
public class SeverityDecorator implements Decorator {

    /**
     * map string severity level
     *
     * @param severity - enum, type severity
     * @return String - level
     */
    public <T> String decorator(T severity) {
        if (Severity.MINOR.equals(severity)) {
            return "()";
        } else if (Severity.REGULAR.equals(severity)) {
            return "(!)";
        } else if (Severity.MAJOR.equals(severity)) {
            return "(!!!)";
        }
        return "";
    }
}
