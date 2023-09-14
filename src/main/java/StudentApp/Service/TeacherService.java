package StudentApp.Service;

import Domen.PersonComparator;
import Domen.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Содержит список учителей.
 * Включает в себя методы создания, сортировки, вывода и печати учителей.
 */
public class TeacherService implements iPersonService<Teacher>{
    /**
     * Количество учителей
     */
    private int count;
    /**
     * Список учителей
     */
    private List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<Teacher>();
    }

    /**
     * Сортирует по фамилии внутренний список
     */
    public void sortByFIO()
    {
        PersonComparator<Teacher> persComp = new PersonComparator<Teacher>();
        teachers.sort(persComp);
    }

    /**
     * Выводит отсортированный список учителей
     */
    public void print() {
        sortByFIO();
        for (Teacher teacher : this.teachers) {
            System.out.println(teacher);
        }
    }

    /**
     * Возвращает список учителей
     * @return
     */
    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    /**
     * Создает новый экземлпяр учителя и добавляет ее в свой список.
     * При этом устанавливается ученую степень "basic".
     * @param name имя
     * @param age возраст
     */
    @Override
    public void create(String name, int age) {
        Teacher teacher = new Teacher(name, age, "basic");
        count++;
        teachers.add(teacher);
    }
}