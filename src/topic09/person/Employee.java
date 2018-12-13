package topic09.person;

public class Employee extends Person {

    private String department;

    public String getDepartment(){
        return department;
    }

    public Employee(String department, String name, String email){
        super(name, email);
        this.department = department;
    }

    @Override
    public String getDescription(){
        return "Works in the" + department + "department";
    }
}
