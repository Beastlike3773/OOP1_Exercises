package topic08.iterator;

import java.util.List;

public class StringListIterator implements Iterator {

    private List<String> sList;
    private int index;

    public StringListIterator(List<String> sList){
        this.sList = sList;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        return sList != null && index < sList.size();
    }

    @Override
    public String next() {
        return sList.get(index++);
    }

    @Override
    public void reset() {
        index = 0;
    }
}
