import model.interfaces.iCalculator;
import model.interfaces.iResult;

/**
 * Калькулятор, работающий со значениями, определенными классом IntResult.
 */
public class IntCalculator implements iCalculator {
    /** Сохраненное в калькуляторе значение */
    private IntResult result;

    /**
     * Конструктор. Устанавливает новое значение IntResult в сохранное значение.
     */
    public IntCalculator() {
        this.result = new IntResult();
    }

    /**
     * Переопределение операции сложения
     * @param arg слагаемое
     * @return IntCalculator
     */
    @Override
    public iCalculator sum(iResult arg) {
        result.value += ((IntResult) arg).value;
        return this;
    }

    /**
     * Переопределение операции умножения
     * @param arg множитель
     * @return IntCalculator
     */
    @Override
    public iCalculator multi(iResult arg) {
        result.value *= ((IntResult) arg).value;
        return this;
    }

    /**
     * Переопределение операции деления
     * @param arg делитель
     * @return IntCalculator
     */
    @Override
    public iCalculator devide(iResult arg) {
        result.value /= ((IntResult) arg).value;
        return this;
    }

    /**
     * Обнуляет значение в калькуляторе
     */
    @Override
    public void reset() {
        result = new IntResult();
    }

    /**
     * Возвращает сохраненный в калькуляторе результат
     * @return IntResult
     */
    @Override
    public iResult getResult() {
        return result;
    }

    /**
     * Возвращает новый экземпляр результата, с которым работает калькулятор
     * @return IntResult
     */
    @Override
    public iResult getNewArgument() {
        return new IntResult();
    }
}