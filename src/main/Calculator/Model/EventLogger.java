import model.interfaces.iObserver;
import model.interfaces.iResult;

/**
 * Логер, работающий через подписку на события калькулятора.
 */
public class EventLogger implements iObserver {
    /** Строковое представление значения в калькуляторе до выполения действия */
    String valueBefore;
    /** Строковое представление аргумента */
    String argument;

    /**
     * Метод вызывается до выполнения действия в калькуляторе. Сохраняет текущее значение и значение аргумента
     * для дальнейшего логирования.
     * @param stateBefore значение до выполнения действия
     * @param arg значение аргумента
     * @param event событие
     */
    @Override
    public void beforeEvent(iResult stateBefore, iResult arg, CalculateEvent event) {
        if (event != CalculateEvent.RESET) {
            valueBefore = stateBefore.toString();
            argument = arg.toString();
        }
    }

    /**
     * Метод вызывается после выполнения действия в калькуляторе. Записывает в лог результат выполнения действия.
     * @param stateAfter значение после выполнения действия
     * @param event событие
     */
    @Override
    public void afterEvent(iResult stateAfter, CalculateEvent event) {
        if (event == CalculateEvent.RESET) {
            System.out.println("Reset калькулятора");
            return;
        }
        StringBuilder sb = new StringBuilder(valueBefore);
        switch (event) {
            case SUM:
                sb.append(" + ");
                break;
            case MULTI:
                sb.append(" * ");
                break;
            case DEVIDE:
                sb.append(" / ");
                break;
        }
        sb.append(argument);
        sb.append(" = ");
        sb.append(stateAfter.toString());
        System.out.println(sb);
    }
}