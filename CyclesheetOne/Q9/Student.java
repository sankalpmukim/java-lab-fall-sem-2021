package Q9;

public class Student {
    public int sum;
    public int[] marks;

    public Student(int[] marksOfStudents) {
        marks = marksOfStudents;
        sum = 0;
    }

    public int getIndividualTotal() {
        sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum;
    }
}
//