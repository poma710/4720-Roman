package StudentApp.Domen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Группа студентов. Содержит в себе список студентов и идентификатор группы.
 * Номер группы задается вручную.
 *
 */
public class StudentGroup implements Iterable<Student>, Comparable<StudentGroup> {

    /** Список групп*/
    private List<Student> group;
    /** Номер группы */
    private Integer idGroup;

    /**
     * Создает новую пустую группу студентов
     * @param idGroup Номер группы
     */
    public StudentGroup(Integer idGroup) {
        this(new ArrayList<Student>(), idGroup);
    }

    /**
     * Создает новую группу студентов из списка студентов
     * @param group Список студентов
     * @param idGroup Номер группы
     */
    public StudentGroup(List<Student> group, Integer idGroup) {
        this.group = group;
        this.idGroup = idGroup;
    }

    /**
     * Возвращает список студентов
     * @return список студентов
     */
    public List<Student> getGroup() {
        return group;
    }

    /**
     * Добавляет студента в группу, если его там еще нет.
     * @param student Студент
     * @return true, если студента не было в группе и он добавлен, false, если студент уже был в группе
     */
    public boolean add(Student student) {
        if (group.contains(student))
            return false;
        group.add(student);
        return true;
    }

    /**
     * Удаляет студента из группы, если он есть в группе
     * @param student Студент
     * @return true, если студент был в группе и удален из нее, false, если студента не было в группе
     */
    public boolean remove(Student student) {
        if (group.contains(student)) {
            group.remove(student);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает новый список студентов
     * @param group список студентов
     */
    public void setGroup(List<Student> group) {
        this.group = group;
    }

    /**
     * Возвращает номер группы
     * @return номер группы
     */
    public Integer getIdGroup() {
        return idGroup;
    }

    /**
     * Изменяет номер группы
     * @param idGroup номер группы
     */
    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Группа: ");
        sb.append(idGroup);
        sb.append(" количество студентов: ");
        sb.append(group.size());
        for (Student s : group) {
            sb.append("\n");
            sb.append(s.getName());
        }
        return sb.toString();
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator(group);
    }

    @Override
    public int compareTo(StudentGroup o) {
        if (group.size() > o.group.size())
            return 1;
        else if (group.size() < o.group.size())
            return -1;

        if (this.idGroup > o.getIdGroup())
            return 1;
        else if (idGroup < o.getIdGroup())
            return -1;

        return 0;
    }

}
