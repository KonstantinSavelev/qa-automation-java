import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.printer.MessageService;


class Application {
    public static void main(String[] args) {
        MessageService.print(Severity.MINOR, "Hello world!", "Hello world!", "Hello world!", "Hello world!", "Hello world!", "Hello world!");
        MessageService.print(Severity.MINOR, MessageOrder.ASC, "Hello world 1!", "Hello world 2!", "Hello world 3!", "Hello world 4!", "Hello world 5!", "Hello world 6!");
        MessageService.print(Severity.MINOR, MessageOrder.DESC, "Hello world 1!", "Hello world 2!", "Hello world 3!","Hello world 4!", "Hello world 5!", "Hello world 6!");
        MessageService.print(Severity.REGULAR, "Hello world!", null);
        MessageService.print(Severity.REGULAR, MessageOrder.ASC, Doubling.DISTINCT, "Hello world!", "Hello world!", "Hello world 1!", "Hello world 1!");
        MessageService.print(Severity.MAJOR, MessageOrder.DESC, Doubling.DISTINCT, "Hello world!", "Hello world!", "Hello world 1!", "Hello world 1!");
        MessageService.print(Severity.REGULAR, MessageOrder.ASC, Doubling.DOUBLES, "Hello world!", "Hello world!", "Hello world 1!", "Hello world 1!");
    }
}