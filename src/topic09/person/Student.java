package topic09.person;

public class Student extends Person {

    private String grade;

    public String getGrade(){
        return grade;
    }

    public Student(String grade, String name, String email){
        super(name, email);

        this.grade = grade;
    }

    @Override
    public String getDescription(){
        return grade + " grade student";
    }
}
