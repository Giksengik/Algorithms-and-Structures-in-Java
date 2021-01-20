import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private final double [] results;
    private final int trials;
    private final double con;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (trials <= 0) throw new IllegalArgumentException();
        results = new double[trials];
        this.trials = trials;
        con = 1.96;
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (true) {
                int b = StdRandom.uniform(n * n + 1);
              while (percolation.isOpen(b / n + 1, b % n + 1)) {
                  b = StdRandom.uniform(n * n +1);
              }
              percolation.open(b / n + 1, b % n + 1);
              if (percolation.percolates()) {
                  double res = percolation.numberOfOpenSites();
                  results[i] = res / (n * n);
                  break;
              }
            }
        }
        mean();
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return (mean() - con * stddev() / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean() + con * stddev() / Math.sqrt(trials));
    }
    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        Stopwatch sw = new Stopwatch();

        PercolationStats perStat = new PercolationStats(n, t);

        System.out.printf("mean                    = %f\n", perStat.mean());
        System.out.printf("stddev                  = %f\n", perStat.stddev());
        System.out.printf("95%% confidence interval = %f, %f\n",
                          perStat.confidenceLo(), perStat.confidenceHi());

        System.out.println("------");
        System.out.printf("Total time: %f secs. (for N=%d, T=%d)",
                          sw.elapsedTime(), n, t);
    }
}
