package StudentApp.Domen;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Итератор списка групп студентов.
 * Создается на основании List<StudentGroup>.
 * Реализованы методы итератора hasNext() и next().
 *
 */
public class GroupIterator implements Iterator<StudentGroup> {
    /** Номер следующей группы */
    private int counter;
    /** Список групп */
    private List<StudentGroup> groups;

    /**
     * Создает новый итератор
     * @param groups список групп
     */
    public GroupIterator(List<StudentGroup> groups) {
        this.groups = groups;
    }

    @Override
    public boolean hasNext() {
        return counter < groups.size();
    }

    @Override
    public StudentGroup next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return groups.get(counter++);
    }
}
