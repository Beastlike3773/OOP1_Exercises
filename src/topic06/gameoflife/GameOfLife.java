package topic06.gameoflife;

import java.util.Arrays;

public class GameOfLife {

    private boolean[][] cells;

    private int n, m;

    public GameOfLife(int n, int m){
        this.n = n;
        this.m = m;
        this.cells = new boolean[n][m];
    }

    public boolean isCellAlive(int n, int m){
        // A cell can have 8 neighbors
        boolean[] neighbors = new boolean[8];
        Arrays.fill(neighbors, false);
        int nr_of_neighbors = 0;

        // Cell that has to be checked for
        boolean cell = this.cells[n][m];

        // Neighbors for corners
        if(n == 0 && m == 0){
            neighbors[0] = this.cells[n+1][m];
            neighbors[1] = this.cells[n+1][m+1];
            neighbors[2] = this.cells[n][m+1];
        }else if(n == this.n-1 && m == 0){
            neighbors[0] = this.cells[n][m+1];
            neighbors[1] = this.cells[n-1][m+1];
            neighbors[2] = this.cells[n-1][m];
        }else if(n == this.n-1 && m == this.m-1){
            neighbors[0] = this.cells[n-1][m-1];
            neighbors[1] = this.cells[n][m-1];
            neighbors[2] = this.cells[n-1][m];
        }else if(n == 0 && m == this.m-1){
            neighbors[1] = this.cells[n][m-1];
            neighbors[2] = this.cells[n+1][m-1];
            neighbors[3] = this.cells[n+1][m];
        }

        // Neighbors for edges
        else if(n == 0){
            neighbors[0] = this.cells[n][m-1];
            neighbors[1] = this.cells[n+1][m-1];
            neighbors[2] = this.cells[n+1][m];
            neighbors[3] = this.cells[n+1][m+1];
            neighbors[4] = this.cells[n][m+1];
        }else if(m == 0){
            neighbors[0] = this.cells[n+1][m];
            neighbors[1] = this.cells[n+1][m+1];
            neighbors[2] = this.cells[n][m+1];
            neighbors[3] = this.cells[n-1][m+1];
            neighbors[4] = this.cells[n-1][m];
        }else if(n == this.n-1){
            neighbors[0] = this.cells[n-1][m-1];
            neighbors[1] = this.cells[n][m-1];
            neighbors[2] = this.cells[n][m+1];
            neighbors[3] = this.cells[n-1][m+1];
            neighbors[4] = this.cells[n-1][m];
        }else if(m == this.m-1){
            neighbors[0] = this.cells[n-1][m-1];
            neighbors[1] = this.cells[n][m-1];
            neighbors[2] = this.cells[n+1][m-1];
            neighbors[3] = this.cells[n+1][m];
            neighbors[4] = this.cells[n-1][m];
        }else{
            neighbors[0] = this.cells[n-1][m-1];
            neighbors[1] = this.cells[n][m-1];
            neighbors[2] = this.cells[n+1][m-1];
            neighbors[3] = this.cells[n+1][m];
            neighbors[4] = this.cells[n+1][m+1];
            neighbors[5] = this.cells[n][m+1];
            neighbors[6] = this.cells[n-1][m+1];
            neighbors[7] = this.cells[n-1][m];
        }

        // Count the number of alive neighbors of this cell
        for(Boolean neighbor : neighbors){
            if(neighbor){
                nr_of_neighbors++;
            }
        }

        // Check the conditions on which a cell can be alive or become alive
        if((nr_of_neighbors == 2 || nr_of_neighbors == 3) && cell){
            return true;
        }else if(nr_of_neighbors == 2 && !cell){
            return true;
        }

        // Return that the cell is dead if none of the above conditions are met
        return false;
    }

    public int getWidth(){
        return this.n;
    }

    public int getHeight(){
        return this.m;
    }

    public void setCell(int i, int j){
        this.cells[i][j] = true;
    }

    public boolean getCell(int i, int j){
        return this.cells[i][j];
    }

    public void nextGeneration() {
        boolean[][] refCells = new boolean[n][m];

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                refCells[i][j] = this.cells[i][j];
            }
        }

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                refCells[i][j] = isCellAlive(i, j);
            }
        }

        this.cells = refCells;
    }

    //private int countNeighbors(int i, int j){
    //    return 0;
    //}

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
