package topic08.iterator;

public class StringIterator implements Iterator {

    private String s;
    private int index;

    public StringIterator(String s){
        this.s = s;
        index = 0;
    }
    @Override
    public boolean hasNext() {
        return s != null && index < s.length(); // left to right
    }

    @Override
    public Character next() {
        return s.charAt(index++);
    }

    @Override
    public void reset() {
        index = 0;
    }
}
