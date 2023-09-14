package StudentApp.Domen;

public class Employee extends Person{
    /**
     * Название специальности
     */
    private String special;

    /**
     * Конструктор, заполняющий все поля класса
     * @param firstName имя
     * @param age возвраст
     * @param special специальность
     */
    public Employee(String firstName, int age, String special) {
        super(firstName, age);
        this.special = special;
    }
}
