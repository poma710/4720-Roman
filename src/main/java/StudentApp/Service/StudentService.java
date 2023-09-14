package StudentApp.Service;

import Domen.PersonComparator;
import Domen.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Содержит список студентов.
 * Включает в себя методы создания, сортировки и вывода студентов.
 */
public class StudentService implements iPersonService<Student> {
    /**
     * Количество студентов
     */
    private int count;
    /**
     * Список студентов
     */
    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    /**
     * Сортирует по фамилии внутренний список
     */
    public void sortByFIO()
    {
        PersonComparator<Student> persComp = new PersonComparator<Student>();
        students.sort(persComp);
    }

    /**
     * Возвращает список студентов
     * @return
     */
    @Override
    public List<Student> getAll() {
        return students;
    }

    /**
     * Создает новый экземлпяр студента и добавляет ее в свой список.
     * @param name имя
     * @param age возраст
     */
    @Override
    public void create(String name, int age) {
        Student stud = new Student(name, age);
        count++;
        students.add(stud);
    }

}
