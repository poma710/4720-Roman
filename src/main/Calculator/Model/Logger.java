import model.interfaces.iLogger;

/**
 * Простейший логгер, выводящий в консоль всю логируемую информацию
 */
public class Logger implements iLogger {

    public void write(String message) {
        System.out.println(message);
    }
}