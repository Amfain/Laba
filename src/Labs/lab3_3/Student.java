package Labs.lab3_3;

public class Student implements Comparable<Student> {
    private final String name;
    private final double averageGrade;

    public Student(String name, double averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.averageGrade, other.averageGrade);
    }

    @Override
    public String toString() {
        return name + " (" + averageGrade + ")";
    }
}
