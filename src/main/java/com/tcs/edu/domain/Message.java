package com.tcs.edu.domain;

import com.tcs.edu.decorator.Severity;

public class Message {
    Severity severity;
    String[] bodies;
    String body;

    public Message(Severity severity, String body) {
        this.severity = severity;
        this.body = body;
    }

    public Message(Severity severity, String[] bodies) {
        this.severity = severity;
        this.bodies = bodies;
    }

    public Severity getSeverity() {
        return this.severity;
    }

    public String getBody() {
        return this.body;
    }

    public String[] getBodies() {
        return this.bodies;
    }
}
