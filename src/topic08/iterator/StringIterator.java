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
    public Object next() {
        return s.substring(index, index++ + 1);
    }

    @Override
    public void reset() {
        index = 0;
    }
}
