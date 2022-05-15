import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.MessageService;


class Application {
    public static void main(String[] args) {

        Message message1 = new Message(Severity.REGULAR, "Hello world 1!");
        Message message2 = new Message(Severity.REGULAR, "Hello world 1!");
        Message message3 = new Message(Severity.MAJOR, "Hello world 3!");

        MessageService service = new MessageService();
        service.print(MessageOrder.ASC, Doubling.DISTINCT, message1, message2, message3);
        service.print(MessageOrder.DESC, Doubling.DISTINCT, message1, message2, message3);
    }
}