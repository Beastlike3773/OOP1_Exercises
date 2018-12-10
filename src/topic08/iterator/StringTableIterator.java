package topic08.iterator;

public class StringTableIterator implements Iterator {

    private String[][] sTable;
    private int row;
    private int column;

    public StringTableIterator(String[][] sTable){
        this.sTable = sTable;
        row = 0; column = 0;
    }
    @Override
    public boolean hasNext() {
        return sTable != null && row < sTable.length;
    }

    @Override
    public String next() {
        if (column < sTable[row].length - 1)
            return sTable[row][column++];

        String temp = sTable[row++][column = 0];
        column = 0;
        return temp;
    }

    @Override
    public void reset() {
        row = 0; column = 0;
    }
}