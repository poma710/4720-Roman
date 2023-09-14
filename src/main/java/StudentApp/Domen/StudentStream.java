package StudentApp.Domen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Класс описывает поток студентов.
 * Характеризуется номером потока и списком групп студентов.
 *
 * Реализованы методы добавления группы в поток, удаления из потока.
 *
 * Предусмотрен обход групп потока оператором for.
 *
 */
public class StudentSteam implements Iterable<StudentGroup>{

    /** Номер потока */
    private int steamNumber;
    /** Список групп */
    private List<StudentGroup> groups;


    /**
     * Создает новый поток с указанным номером
     * @param steamNumber номер потока
     */
    public StudentSteam(int steamNumber) {
        groups = new ArrayList<StudentGroup>();
        this.steamNumber = steamNumber;
    }

    /**
     * Добавляет группу студентов в поток
     * @param group группа студентов
     */
    public void add(StudentGroup group) {
        groups.add(group);
    }

    /**
     * Удаляет группу из потока. Если группы нет в потоке, возвращает false.
     * @param group Группа студентов
     * @return true, если группа была и удалось ее удалить, false, если группы нет в потоке
     */
    public boolean remove(StudentGroup group) {
        if (groups.contains(group)) {
            groups.remove(group);
            return true;
        }
        return false;
    }

    /**
     * Возвращает список групп потока
     * @return список групп потока
     */
    public List<StudentGroup> getGroups() {
        return groups;
    }

    /**
     * Сортирует группы в потоке и студентов во всех группах
     */
    public void sortSteam() {
        Collections.sort(groups);
        for (StudentGroup gr: groups)
            Collections.sort(gr.getGroup());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Номер потока: ");
        sb.append(this.steamNumber);
        sb.append(", количество групп: ");
        sb.append(this.groups.size());
        for (StudentGroup gr: groups) {
            for (Student s: gr) {
                sb.append("\n");
                sb.append(s.getName() + ", группа: " + gr.getIdGroup());
            }
        }
        return sb.toString();
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new GroupIterator(groups);
    }


}