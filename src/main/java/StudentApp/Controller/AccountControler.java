package StudentApp.Controller;

import Domen.Person;
import Domen.Teacher;

import java.util.List;

/**
 * Класс, содержащий дополнительные методы для работы с остальными классами
 */
public class AccountController {
    /**
     * Имитирует выплату зарплаты учителю
     * @param person получатель
     * @param salary сумма
     * @param <T>
     */
    public static <T extends Teacher> void paySalary(T person, int salary) {
        System.out.println(person.getName() + " выплачено зарплата " + salary + "р. ");
    }

    /**
     * Возвращает средний возраст переданной группы
     * @param persons список экзепляров класса потомка Persons
     * @return средний возраст
     * @param <T>
     */
    public static <T extends Person> double averageAge(List<T> persons)
    {
        double sum = 0;
        for (T person : persons) {
            sum += person.getAge();
        }
        return sum / persons.size();
    }

}