package com.tcs.edu.domain;

import com.tcs.edu.decorator.Severity;

import java.util.Objects;

public class Message {
    Severity severity;
    String body;

    public Message(Severity severity, String body) {
        this.severity = severity;
        this.body = body;
    }

    public Severity getSeverity() {
        return this.severity;
    }

    public String getBody() {
        return this.body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return severity == message.severity && Objects.equals(body, message.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(severity, body);
    }

    @Override
    public String toString() {
        return "Message{" +
                "severity=" + severity +
                ", body='" + body + '\'' +
                '}';
    }
}
