package com.tcs.edu.printer;

import com.tcs.edu.domain.Message;

public abstract class ValidatedService {

    public boolean isArgsValid(Message message){
        if (message == null) throw new IllegalArgumentException("someArg is null");
        if (message.getBody() == null) throw new IllegalArgumentException("otherArg is empty");

        return true;
    }
}
