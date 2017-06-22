public class PercolationStats {

    private double arrayT[];
    private double mean;
    private double stddev;
    private int    N;

    public PercolationStats(int N, int T) {
        arrayT = new double[T];
        this.N = N;
        int times = 0;
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        if (T <= 0) {
            throw new IllegalArgumentException();
        }
        while (times < T) {
            Percolation percolation = new Percolation(N);
            boolean[][] arrOpen = new boolean[N + 1][N + 1];
            int count = 0;
            while (true) {
                count++;
                while (true) {
                    int x = StdRandom.uniform(N) + 1;
                    int y = StdRandom.uniform(N) + 1;
                    if (!arrOpen[x][y]) {
                        percolation.open(x, y);
                        arrOpen[x][y] = true;
                        break;
                    }
                }
                if (percolation.percolates()) {
                    arrayT[times] = (double) count / ((double) N * (double) N);
                    break;
                }
            }
            times++;
        }
        mean = StdStats.mean(arrayT);
        stddev = StdStats.stddev(arrayT);
    }

    public double mean() {
        return mean;

    }

    public double stddev() {
        return stddev;

    }

    public double confidenceLo() {
        return mean - 1.96 * stddev / Math.sqrt(N);

    }

    public double confidenceHi() {
        return mean + 1.96 * stddev / Math.sqrt(N);

    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int T = StdIn.readInt();
        PercolationStats percolationStats = new PercolationStats(N, T);
        StdOut.println("mean = " + percolationStats.mean);
        StdOut.println("stddev = " + percolationStats.stddev);
        StdOut.println("95% confidence interval = "
                + percolationStats.confidenceLo() + ", "
                + percolationStats.confidenceHi());
    }
}
