import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class PercolationStats {

    private double[] thresholdR;
    private int trials;

    public PercolationStats(int n, int trials)
    {
        ///The constructor should throw a java.lang.IllegalArgumentException if either N <= 0 or T >= 0.
        if (n<1 || trials<1)
        {
            throw new IllegalArgumentException("both arguments n and T must be greater than 1");
        }

        this.trials = trials;
        thresholdR = new double[trials];
        for (int t = 0; t < trials; t++)
        {
            Percolation percolation = new Percolation(n);
            int openSites = 0;
            while (!percolation.percolates())
            {
                int i = StdRandom.uniform(1,n+1);
                int j = StdRandom.uniform(1,n+1);

                if (!percolation.isOpen(i,j))
                {
                    percolation.open(i,j);
                    openSites += 1;
                }
            }
            double threshold = (double)openSites/(double)(n*n);
            thresholdR[t] = threshold;
        }
    }
    // sample mean of percolation threshold
    public double mean()
    {
        return StdStats.mean(thresholdR);
    }
    // sample standard deviation of percolation threshold
    public double stddev()
    {
        return StdStats.stddev(thresholdR);
    }
    // returns lower bound of the 95% confidence interval
    public double confidenceLo()
    {
        return mean() - (1.96*stddev()/Math.sqrt(trials));
    }
    // returns upper bound of the 95% confidence interval
    public double confidenceHi()
    {
        return mean() + (1.96*stddev()/Math.sqrt(trials));
    }


    public static void main(String[] args)
    {
    }



}
