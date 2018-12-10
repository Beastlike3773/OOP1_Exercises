package topic08.iterator;

public class DigitsIterator implements Iterator {

    private int digit;

    public DigitsIterator(){
        digit = 0;
    }
    @Override
    public boolean hasNext() {
        return digit < 10;
    }

    @Override
    public Integer next() {
        return digit++;
    }

    @Override
    public void reset() {
        digit = 0;
    }
}
