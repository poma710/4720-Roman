import model.CalculatorWithEvent;
import model.CalculatorWithLogger;
import model.EventLogger;
import model.Logger;
import model.core.ComplexCalculator;
import view.View;

public class Controller {
    public void run() {
        View view;

         код */
        CalculatorWithEvent calc = new CalculatorWithEvent(new ComplexCalculator());
        calc.addObserver(new EventLogger());
        view = new View(calc);
        view.run();
    }
}
