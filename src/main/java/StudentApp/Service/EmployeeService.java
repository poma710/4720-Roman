package StudentApp.Service;

import Domen.Employee;
import Domen.PersonComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Содержит список работников.
 * Включает в себя методы создания, сортировки и вывода работников.
 */
public class EmployeeService implements iPersonService<Employee> {
    /**
     * Количество работников
     */
    private int count;
    /**
     * Список работников
     */
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    /**
     * Сортирует по фамилии внутренний список
     */
    public void sortByFIO()
    {
        PersonComparator<Employee> persComp = new PersonComparator<Employee>();
        employees.sort(persComp);
    }

    /**
     * Возвращает список работников
     * @return
     */
    @Override
    public List<Employee> getAll() {
        return employees;
    }

    /**
     * Создает новый экземлпяр работника и добавляет ее в свой список.
     * При этом устанавливается специальность "basic".
     * @param name имя
     * @param age возраст
     */
    @Override
    public void create(String name, int age) {
        Employee epls = new Employee(name, age, "basic");
        count++;
        employees.add(epls);
    }

}