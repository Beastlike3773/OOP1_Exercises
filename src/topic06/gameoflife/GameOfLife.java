package topic06.gameoflife;

public class GameOfLife {

    private int width, height;
    private boolean[][] cells;

    public GameOfLife(int n, int m){
        this.cells = new boolean[n][m];
    }

    private boolean isCellAlive(int n, int m){
        // A cell can have 8 neighbors
        boolean[] neighbors = new boolean[8];
        int nr_of_neighbors = 0;

        // Cell that has to be checked for
        boolean cell = this.cells[n][m];

        // Start on top left cell and go clockwise
        neighbors[0] = this.cells[n-1][m-1];
        neighbors[1] = this.cells[n][m-1];
        neighbors[2] = this.cells[n+1][m-1];
        neighbors[3] = this.cells[n+1][m];
        neighbors[4] = this.cells[n+1][m+1];
        neighbors[5] = this.cells[n][m+1];
        neighbors[6] = this.cells[n-1][m+1];
        neighbors[7] = this.cells[n-1][m];

        // Count the number of alive neighbors of this cell
        for(Boolean neighbor : neighbors){
            if(neighbor){
                nr_of_neighbors++;
            }
        }

        // Check the conditions on which a cell can be alive or become alive
        if((nr_of_neighbors == 2 || nr_of_neighbors == 3) && cell){
            return true;
        }else if(nr_of_neighbors == 3 && cell){
            return true;
        }

        // Return that the cell is dead if none of the above conditions are met
        return false;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void setCell(int i, int j){

    }

    public int getCell(int i, int j){

    }

    public void nextGeneration(){

    }

    private int countNeighbors(int i, int j){

    }

    public void createBlinker(int i, int j){
        setCell(i,j);
        setCell(i+1,j);
        setCell(i+2,j);
    }

    public void createGlider(int i, int j){
        setCell(i,j);
        setCell(i+1,j);
        setCell(i,j-2);
        setCell(i+2,j);
        setCell(i+2,j-1);
    }

    public void createPentomino(int i,int j){
        setCell(i,j);
        setCell(i+1,j);
        setCell(i+1,j+1);
        setCell(i+1,j-1);
        setCell(i+2,j-1);
    }
}
