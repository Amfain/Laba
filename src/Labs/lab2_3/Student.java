package Labs.lab2_3;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student other) {
        int nameComp = this.name.compareTo(other.name);
        if (nameComp != 0) {
            return nameComp;
        }
        return Integer.compare(this.age, other.age);
    }
}
