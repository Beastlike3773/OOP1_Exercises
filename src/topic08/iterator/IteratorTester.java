package topic08.iterator;

import java.util.ArrayList;


/**
 * Tests the classes StringIterator, StringListIterator,
 * StringTableIterator and DigitsIterator
 * implementing the Iterator interface
 *
 * @author lua
 *
 */
public class IteratorTester {

    public static void main(String[] args) {
        ArrayList<Iterator> iterators = new ArrayList<Iterator>();

        // StringIterator
        iterators.add(new StringIterator("Hello"));
        iterators.add(new StringIterator("World"));
        iterators.add(new StringIterator(""));
        iterators.add(new StringIterator(null));

        // StringListIterator
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello");
        strings.add("World");
        iterators.add(new StringListIterator(strings));
        //iterators.add(new StringListIterator(null));

        // StringTableIterator
        String[][] strTable = { { "Hello", "World", "!" }, { "Hallo", "Welt" },
                { "Bonjour", "Monde" } };
        iterators.add(new StringTableIterator(strTable));

        // DigitsIterator
        iterators.add(new DigitsIterator());

        // Loop over all iterators
        for (int i = 1; i <= 2; i++) {
            System.out.println("**** Round " + i + " ****");
            for (Iterator iterator : iterators) {
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
                System.out.println("");
                iterator.reset();
            }
        }
    }

}
