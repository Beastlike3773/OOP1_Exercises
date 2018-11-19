package topic07.coursestudent;

public class Student {

    private long id;
    private double grade;

    /**
     * Creates a new student with id and grade
     * @param id of the student
     * @param grade of the student
     */
    public Student(long id, double grade){
        this.id = id;
        this.grade = grade;
    }

    /**
     * Gets the id of the student
     * @return id of student
     */
    public long getId(){
        return this.id;
    }

    /**
     * Gets the grade of the student
     * @return grade of student
     */
    public double getGrade(){
        return this.grade;
    }
}
