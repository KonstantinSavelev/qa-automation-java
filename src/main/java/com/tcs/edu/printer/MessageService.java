package com.tcs.edu.printer;

import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.domain.Message;

public interface MessageService {

    void print(Message... messages);

    void print(MessageOrder order, Message... messages);

    void print(MessageOrder order, Doubling doubling, Message... messages);

}
