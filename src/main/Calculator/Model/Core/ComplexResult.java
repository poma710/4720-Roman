import model.interfaces.iResult;

import java.util.Scanner;

public class ComplexResult implements iResult {

    public int realValue;
    public int imgValue;

    public ComplexResult(int realValue, int imgValue) {
        this.realValue = realValue;
        this.imgValue = imgValue;
    }

    public ComplexResult() {
        this(0, 0);
    }

    @Override
    public iResult promptArgument(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message + " (действительная часть): ");
        this.realValue = Integer.parseInt(in.nextLine());
        System.out.print(message + " (мнимая часть): ");
        this.imgValue = Integer.parseInt(in.nextLine());
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d%s%di", realValue, imgValue < 0 ? "-" : "+", Math.abs(imgValue));
    }
}