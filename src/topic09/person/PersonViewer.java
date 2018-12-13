package topic09.person;

/**
 * Dumps out the command-line information about a Person object.
 */
public class PersonViewer {
    /**
     * View the person
     */
    public void view(Person person) {
        System.out.println(person.getClass().getSimpleName() + ": ");

        System.out.println("  Name: " + person.getName());
        System.out.println("  Email: " + person.getEmail());
        System.out.println("  Description: " + person.getDescription());
        System.out.println("\n");
    }

}
