package topic07.coursestudent;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String id;
    private String instructorName;

    private List<Student> students;
    /**
     * Creates a new course with an id and course instructor
     * @param id of the course
     * @param instructorName of the course instructor
     * (Preconditions: id != null && instructorName != null)
     */
    public Course(String id, String instructorName){
        assert id != null && instructorName != null;

        this.id = id;
        this.instructorName = instructorName;

        this.students = new ArrayList<>();
    }

    public String getId(){
        return this.id;
    }

    public String getInstructorName(){
        return this.instructorName;
    }

    /**
     * Adds a new student to the course
     * @param student to be added to the course
     * (Precondition: student != null)
     * (Postcondition: getNumberOfStudents > 0)
     */
    public void addStudent(Student student){
        assert student != null;

        if(student == null) throw new IllegalArgumentException();

        this.students.add(student);

        assert getNumberOfStudents() > 0;
    }

    /**
     * Removes a student from course
     * @param student to be removed from course
     * (Precondition: student != null)
     * (Postcondition: getNumberOfStudents >= 0)
     */
    public void removeStudent(Student student){
        assert student != null;

        if(student == null) throw new IllegalArgumentException();

        for(Student s : this.students){
            if(s.getId() == student.getId()){
                this.students.remove(s);
                break;
            }
        }

        assert getNumberOfStudents() >= 0;
    }

    /**
     * Gets the number of students in the course
     * @return number of stutends in course
     */
    public int getNumberOfStudents(){
        return this.students.size();
    }

    /**
     * Gets the average grade of the students in the course
     * rounded to 2 decimal points
     * @return average grade of students
     * (Precondition: getNumberOfStudents > 0)
     */
    public double getGradeAverage(){
        assert getNumberOfStudents() > 0;
        double average = 0d;

        for(Student s : this.students){
            average += s.getGrade();
        }

        average /= getNumberOfStudents();

        return Math.round(average * 100d) / 100d;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "";
    }
}
