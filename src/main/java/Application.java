import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.Service;


class Application {
    public static void main(String[] args) {

        Message message1 = new Message(Severity.REGULAR, "Hello world 1!");
        Message message2 = new Message(Severity.REGULAR, "Hello world 1!");
        Message message3 = new Message(Severity.MAJOR, "Hello world 3!");

        Service service = new Service();
        service.print(MessageOrder.ASC, Doubling.DISTINCT, message1, message2, message3);
        service.print(MessageOrder.DESC, Doubling.DISTINCT, message1, message2, message3);


        var test = message1;
        System.out.println(message1.hashCode());
        System.out.println(test.hashCode());
        System.out.println(message1);
        System.out.println(message1.equals(message2));

    }
}