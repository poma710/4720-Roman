import model.CalculateEvent;

/**
 * Интерфейс, определяющий методы подписчиков на обработку событий в калькуляторе
 */
public interface iObserver {
    /**
     * Метод вызывается до выполнения действия в калькуляторе
     * @param stateBefore значение до выполнения действия
     * @param arg значение аргумента
     * @param event событие
     */
    void beforeEvent(iResult stateBefore, iResult arg, CalculateEvent event);

    /**
     * Метод вызывается после выполнения действия в калькуляторе
     * @param stateAfter значение после выполнения действия
     * @param event событие
     */
    void afterEvent(iResult stateAfter, CalculateEvent event);
}