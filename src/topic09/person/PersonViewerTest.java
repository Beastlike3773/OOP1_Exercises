package topic09.person;

public class PersonViewerTest {

    public static void main(String[] args){
        PersonViewer pv = new PersonViewer();
        pv.view(new Professor("Math", "Tam Tom", "tamtom@gmail.com"));
        pv.view(new Employee("IT", "Juli Haldi", "julihaldi@hotmail.ch"));
        pv.view(new Student("A", "Janick Tatum", "janicktatum@gmail.com"));
    }
}
