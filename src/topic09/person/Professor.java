package topic09.person;

public class Professor extends Person {

    private String subject;

    public String getSubject(){
        return subject;
    }

    public Professor(String subject, String name, String email){
        super(name, email);
        this.subject = subject;
    }

    public String getDescription(){
        return "Teaches " + subject;
    }
}
