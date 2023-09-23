import model.interfaces.iCalculator;
import model.interfaces.iResult;

import java.util.Scanner;

/**
 * Обеспечивает взаимодействие с пользователем: ввод команд и вывод результата.
 */
public class View {

    /** Используемый калькулятор */
    private iCalculator calculator;

    /**
     * Конструктор. Устанавливает используемый калькулятор.
     * @param calculator используемый калькулятор
     */
    public View(iCalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Основной метод взаимодействия с пользователем.
     */
    public void run() {
        while (true) {
            calculator.reset();
            iResult primaryArg = calculator.getNewArgument().promptArgument("Введите первый аргумент");
            calculator.sum(primaryArg);
            while (true) {
                String cmd = prompt("Введите команду (*, +, /, =) : ");
                if (cmd.equals("=")) {
                    iResult result = calculator.getResult();
                    System.out.printf("Результат %s\n", result);
                    break;
                }
                if (cmd.equals("*")) {
                    iResult arg = calculator.getNewArgument().promptArgument("Введите второй аргумент");
                    calculator.multi(arg);
                } else if (cmd.equals("+")) {
                    iResult arg = calculator.getNewArgument().promptArgument("Введите второй аргумент");
                    calculator.sum(arg);
                } else if (cmd.equals("/")) {
                    iResult arg = calculator.getNewArgument().promptArgument("Введите второй аргумент");
                    calculator.devide(arg);
                } else {
                    System.out.println("Неизвестная команда");
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    /**
     * Запрашивает от пользователя ввод строковых данных
     * @param message Сообщение пользователю
     * @return введенная пользователем строка
     */
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}