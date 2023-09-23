import model.interfaces.iCalculator;
import model.interfaces.iLogger;
import model.interfaces.iResult;

/**
 * Декоратор, логирующий все выполняемые пользователем команды в формате:
 * <ЗначениеВКалькуляторе> <ВыполняемоеДействие> <ВторойАргументОперации> = <РезультатОперации>
 *     Например, если в калькуляторе было сохранено значение 5, вызов sum(4) добавит в лог запись
 *     5 + 4 = 9
 */
public class CalculatorWithLogger implements iCalculator {
    /** Используемый калькулятор */
    private iCalculator calculator;
    /** Используемый логер */
    private iLogger logger;

    /**
     * Конструктор, устанавливающий калькулятор и логер
     * @param calculator используемый калькулятор
     * @param logger используемый логер
     */
    public CalculatorWithLogger(iCalculator calculator, iLogger logger) {
        this.calculator = calculator;
        this.logger = logger;
    }

    /**
     * Переопределение операции сложения. Логируется.
     * @param arg слагаемое
     * @return CalculatorWithLogger
     */
    @Override
    public iCalculator sum(iResult arg) {
        String before = calculator.getResult().toString();
        calculator.sum(arg);
        logger.write(String.format("%s + %s = %s", before, arg, calculator.getResult()));
        return this;
    }

    /**
     * Переопределение операции умножения. Логируется.
     * @param arg множитель
     * @return CalculatorWithLogger
     */
    @Override
    public iCalculator multi(iResult arg) {
        String before = calculator.getResult().toString();
        calculator.multi(arg);
        logger.write(String.format("(%s) * (%s) = (%s)", before, arg, calculator.getResult()));
        return this;
    }

    /**
     * Переопределение операции деления. Логируется.
     * @param arg делитель
     * @return CalculatorWithLogger
     */
    @Override
    public iCalculator devide(iResult arg) {
        String before = calculator.getResult().toString();
        calculator.devide(arg);
        logger.write(String.format("(%s) / (%s) = (%s)", before, arg, calculator.getResult()));
        return this;
    }

    /**
     * Обнуляет значение в калькуляторе. Логируется.
     */
    @Override
    public void reset() {
        logger.write("Reset калькулятора");
        calculator.reset();
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