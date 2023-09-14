package StudentApp.Domen;

public class Student extends Person implements Comparable<Student> {

    /** Счетчик идентификаторов по всем объектам класса*/
    private static int generalId;

    /** Идентификатор текущего объекта */
    private int id;

    /**
     * Создает нового студента
     * @param name Имя
     * @param age Возраст
     */
    public Student(String name, int age) {
        super(name, age);
        this.id = generalId++;
    }

    @Override
    public int compareTo(Student o) {

        if (super.getAge() == o.getAge()) {
            if (id == o.id)
                return 0;
            if (id > o.id)
                return 1;
            else
                return -1;
        }

        if (super.getAge() > o.getAge())
            return 1;
        else
            return -1;
    }

    /** Возвращает id
     * @return id
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Students [age=" + super.getAge() + ", name=" + super.getName() + ", id=" + id + "]";
    }

}
