package percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import percolation.Percolation;

public class PercolationStats {
    int[] results;
    
    public PercolationStats(int n, int trials) {
        results = new int[trials];
        for (int i=0; i<trials; i++) {
          Percolation p = new Percolation(n);
          results[i] = p.numberOfOpenSites();
        }
        
    }
   
    public double mean() {
        return StdStats.mean(results);
    }
   
    public double stddev() {
        return 1.1;
    }
   
    public double confidenceLo() {
        return 1.1;
    }
   
    public double confidenceHi() {
        return 1.1;
    }

    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]),
                                                   Integer.parseInt(args[1]));
        System.out.println("mean = " + ps.mean());
        System.out.println("stddev = " + ps.stddev());
        System.out.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() +"]");
    }
}