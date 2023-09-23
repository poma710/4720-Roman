import model.interfaces.iResult;

import java.util.Scanner;

/**
 * Класс описывает результат вычисления типа int.
 * Используется в калькуляторе, работающем с типом int.
 */
public class IntResult implements iResult {
    /** Значение, сохраненное в калькуляторе */
    public int value;

    /**
     * Конструктор с указанием нового значения в калькуляторе
     * @param newValue новое значение
     */
    public IntResult(int newValue) {
        this.value = newValue;
    }

    /**
     * Конструктор без указания нового значения. Будет установлено значение 0.
     */
    public IntResult() {
        this(0);
    }

    /**
     * Запрашивает аргумент у пользователя
     * @param message Сообщение пользователю
     * @return экземпляр класса iResult
     */
    @Override
    public iResult promptArgument(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message + ": ");
        this.value = Integer.parseInt(in.nextLine());
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d", value);
    }
}