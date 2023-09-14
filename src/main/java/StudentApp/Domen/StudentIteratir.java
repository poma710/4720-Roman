package StudentApp.Domen;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Итератор списка студентов.
 * Создается на основании List<Student>.
 * Реализованы методы итератора hasNext() и next().
 *
 */
public class StudentIterator implements Iterator<Student> {
    /** Номер следующего студента из переданного списка */
    private int counter;
    /** Список студентов */
    private final List<Student> students;

    /**
     * Создает итератор по переданному списку студентов
     * @param students Список студентов
     */
    public StudentIterator(List<Student> students) {
        this.students = students;
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < students.size();
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return students.get(counter++);
    }

}
