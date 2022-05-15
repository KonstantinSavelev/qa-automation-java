package com.tcs.edu.printer;

import com.tcs.edu.domain.Message;

public abstract class ValidatedService {

    public boolean isArgsValid(Message message){
        if (message == null) return false;
        if (message.getBody() == null) return false;

        return true;
    }
}
