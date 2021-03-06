package percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    int n;
    WeightedQuickUnionUF qu;
    boolean[][] grid;
    
    public Percolation(int n) {
        if (n <= 0) throw new java.lang.IllegalArgumentException();
        
        this.n = n; 
        
        qu = new WeightedQuickUnionUF((n*n)+2);
        grid = new boolean[n][n];
        
        for (int i = 1; i <= n; i++) {
           qu.union(0, i);
           qu.union((n*n)+1, (n*n)-i);
        }
        
        System.out.println(qu.count());
        
        // while (!percolates()) {
          
        // }
    }
    
    public void open(int row, int col) {
        if (row < 1 &&
            row > n &&
            col < 1 &&
            col > n) throw new java.lang.IllegalArgumentException();
       
        int rowIndex = row - 1;
        int colIndex = col - 1;
        
        // If site is already open then interrupt method
        if (grid[rowIndex][colIndex] == true) return;
        
        // Open site
        grid[rowIndex][colIndex] = true;
        
        if (row != 1 & grid[rowIndex-1][colIndex] == true) {
          qu.union(row*col-1, );
        }
        if (row != n & grid[rowIndex+1][colIndex] == true) {
          qu.union(row*col-1, );
        }
        if (col != 1 & grid[rowIndex][colIndex-1] == true) {
          qu.union(row*col-1, );
        }
        if (col != n & grid[rowIndex][colIndex+1] == true) {
          qu.union(row*col-1, );
        }
    }
    
    public boolean isOpen(int row, int col) {
        row -= 1;
        col -= 1;
        return grid[row][col];
    }
   
    public boolean isFull(int row, int col) {
        int p = 0;
        int q = row*col;
        return qu.connected(p, q);
    }
   
    public int numberOfOpenSites() {
        return 1;
    }
   
    public boolean percolates() {
        return qu.connected(0, n*n+1);
    }

    public static void main(String[] args) {
        
    }
}