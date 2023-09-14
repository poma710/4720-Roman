package StudentApp.Domen;

public class Teacher extends Person {
    /**
     * Ученая степень
     */
    private String acadDegree;

    /**
     * Конструктор, заполняющий все поля класса
     * @param firstName имя
     * @param age возвраст
     * @param acadDegree ученая степень
     */
    public Teacher(String firstName, int age, String acadDegree) {
        super(firstName, age);
        this.acadDegree = acadDegree;
    }

    @Override
    public String toString() {
        return super.toString() + "acadDegree='" + acadDegree + '\'';
    }
}
