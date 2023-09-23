import model.interfaces.iCalculator;
import model.interfaces.iResult;

/**
 * Калькулятор, работающий со значениями, определенными классом ComplexResult.
 * Действительная и мнимая часть числа представлена значениями типа Int
 */
public class ComplexCalculator implements iCalculator {
    /** Сохраненное в калькуляторе значение */
    private ComplexResult result;

    /**
     * Конструктор. Устанавливает новое значение ComplexResult в сохранное значение.
     */
    public ComplexCalculator() {
        result = new ComplexResult();
    }

    /**
     * Переопределение операции сложения
     * @param arg слагаемое
     * @return ComplexCalculator
     */
    @Override
    public iCalculator sum(iResult arg) {
        result.realValue += ((ComplexResult) arg).realValue;
        result.imgValue += ((ComplexResult) arg).imgValue;
        return this;
    }

    /**
     * Переопределение операции умножения
     * @param arg множитель
     * @return ComplexCalculator
     */
    @Override
    public iCalculator multi(iResult arg) {
        int real = result.realValue * ((ComplexResult) arg).realValue - result.imgValue * ((ComplexResult) arg).imgValue;
        int img = result.realValue * ((ComplexResult) arg).imgValue + result.imgValue * ((ComplexResult) arg).realValue;
        result.realValue = real;
        result.imgValue = img;
        return this;
    }

    /**
     * Переопределение операции деления
     * @param arg делитель
     * @return ComplexCalculator
     */
    @Override
    public iCalculator devide(iResult arg) {
        int real = (int) ((result.realValue * ((ComplexResult) arg).realValue + result.imgValue * ((ComplexResult) arg).imgValue)
                / (Math.pow(((ComplexResult) arg).realValue, 2) + Math.pow(((ComplexResult) arg).imgValue, 2)));
        int img = (int) ((result.imgValue * ((ComplexResult) arg).realValue - result.realValue * ((ComplexResult) arg).imgValue)
                / (Math.pow(((ComplexResult) arg).realValue, 2) + Math.pow(((ComplexResult) arg).imgValue, 2)));
        result.realValue = real;
        result.imgValue = img;

        return this;
    }

    /**
     * Обнуляет значение в калькуляторе
     */
    @Override
    public void reset() {
        result = new ComplexResult();
    }

    /**
     * Возвращает сохраненный в калькуляторе результат
     * @return ComplexResult
     */
    @Override
    public iResult getResult() {
        return result;
    }

    /**
     * Возвращает новый экземпляр результата, с которым работает калькулятор
     * @return ComplexResult
     */
    @Override
    public iResult getNewArgument() {
        return new ComplexResult();
    }
}