package StudentApp.Service;

import java.util.List;

/**
 * Интерфейс, включающий методы вывода и создания экземпляров подстановочного класса.
 * @param <T>
 */
public interface iPersonService<T> {
    List<T> getAll();
    void create(String name, int age);
}
