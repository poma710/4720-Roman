/**
 * Интерфейс, описывающий методы всех калькуляторов
 */
public interface iCalculator {
    /**
     * Прибавляет переданное значение к сохраненному в калькуляторе.
     * @param arg слагаемое
     * @return интерфейс iCalculator
     */
    iCalculator sum(iResult arg);

    /**
     * Умножает переданное значение на сохраненное в калькуляторе.
     * @param arg множитель
     * @return интерфейс iCalculator
     */
    iCalculator multi(iResult arg);

    /**
     * Делит значение в калькуляторе на переданное значение.
     * @param arg делитель
     * @return интерфейс iCalculator
     */
    iCalculator devide(iResult arg);

    /**
     * Обнуляет значение в калькуляторе
     */
    void reset();

    /**
     * Возвращает значение из калькулятора
     * @return
     */
    iResult getResult();

    /**
     * Возвращает новый экземпляр значения для используемого калькулятора.
     * @return
     */
    iResult getNewArgument();
}
