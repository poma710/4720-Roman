import model.interfaces.iCalculator;
import model.interfaces.iObserver;
import model.interfaces.iResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Декоратор, обеспечивающий возможность подписаться на события вычисления.
 */
public class CalculatorWithEvent implements iCalculator {
    /** Используемый калькулятор */
    private iCalculator calculator;
    /** Используемый логер */
    private List<iObserver> observers;

    /**
     * Конструктор, устанавливающий калькулятор и логер
     * @param calculator используемый калькулятор
     */
    public CalculatorWithEvent(iCalculator calculator) {
        this.calculator = calculator;
        this.observers = new ArrayList<>();
    }

    /**
     * Добавляет нового подписчика
     * @param observer подписчик
     */
    public void addObserver(iObserver observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    /**
     * Удаляет подписчика
     * @param observer подписчик
     */
    public void removeObserver(iObserver observer) {
        if (observers.contains(observer))
            observers.remove(observer);
    }

    /**
     * Отправляет подписчикам событие перед выполнением операции
     * @param event событие
     */
    public void sendEventBefore(CalculateEvent event, iResult arg) {
        for (iObserver observer : observers) {
            observer.beforeEvent(calculator.getResult(), arg, event);
        }
    }

    /**
     * Отправляет подписчикам событие после выполнения операции
     * @param event событие
     */
    public void sendEventAfter(CalculateEvent event) {
        for (iObserver observer : observers) {
            observer.afterEvent(calculator.getResult(), event);
        }
    }

    /**
     * Переопределение операции сложения. Событие отправляется подписчикам.
     * @param arg слагаемое
     * @return iCalculator
     */
    @Override
    public iCalculator sum(iResult arg) {
        sendEventBefore(CalculateEvent.SUM, arg);
        calculator.sum(arg);
        sendEventAfter(CalculateEvent.SUM);
        return this;
    }

    /**
     * Переопределение операции умножения. Событие отправляется подписчикам.
     * @param arg множитель
     * @return iCalculator
     */
    @Override
    public iCalculator multi(iResult arg) {
        sendEventBefore(CalculateEvent.MULTI, arg);
        calculator.multi(arg);
        sendEventAfter(CalculateEvent.MULTI);
        return this;
    }

    /**
     * Переопределение операции деления. Событие отправляется подписчикам.
     * @param arg делитель
     * @return iCalculator
     */
    @Override
    public iCalculator devide(iResult arg) {
        sendEventBefore(CalculateEvent.DEVIDE, arg);
        calculator.devide(arg);
        sendEventAfter(CalculateEvent.DEVIDE);
        return this;
    }

    /**
     * Обнуляет значение в калькуляторе. Событие отправляется подписчикам.
     */
    @Override
    public void reset() {
        sendEventBefore(CalculateEvent.RESET, null);
        calculator.reset();
        sendEventAfter(CalculateEvent.RESET);
    }

    /**
     * Возвращает сохраненный в калькуляторе результат
     * @return iResult
     */
    @Override
    public iResult getResult() {
        return calculator.getResult();
    }

    /**
     * Возвращает новый экземпляр результата, с которым работает калькулятор
     * @return iResult
     */
    @Override
    public iResult getNewArgument() {
        return calculator.getNewArgument();
    }

}