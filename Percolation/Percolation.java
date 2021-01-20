import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    private int n;
    private int count;

    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean [][] openedCells;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)   {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        else this.n = n;
        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);
        for (int i = 0; i < n; i++) {
            weightedQuickUnionUF.union(n * n, i);
            weightedQuickUnionUF.union(n * n + 1, n*n-i-1);
        }
        openedCells = new boolean[n][n];
    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        isCorrectInput(row-1, col-1);
        if (!isOpen(row, col))
            {
            openedCells[row-1][col-1] = true;
            count++;
            checkNearCellsForOpennessAndMakeNewConnections(row-1, col-1);
            }
    }
    private void checkNearCellsForOpennessAndMakeNewConnections(int row, int col)
    {
        if (row > 0)
        {
            if (openedCells[row - 1][col]) weightedQuickUnionUF.union((row * n + col), ((row - 1) * n + col));
        }
        if (row < n-1) {
            if (openedCells[row + 1][col]) weightedQuickUnionUF.union((row * n + col), ((row + 1) * n + col));
        }
        if (col > 0) {
            if (openedCells[row][col - 1]) weightedQuickUnionUF.union((row * n + col), (row * n + col - 1));
        }
        if (col < n-1) {
            if (openedCells[row][col + 1]) weightedQuickUnionUF.union((row * n + col), (row * n + col + 1));
        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isCorrectInput(row-1, col-1);
        return openedCells[row-1][col-1];
    }

        // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        isCorrectInput(row-1, col-1);
        return weightedQuickUnionUF.find((row-1) * n + col-1) == weightedQuickUnionUF.find(n * n) && openedCells[row-1][col-1];
    }
    private void isCorrectInput(int row, int col) {
        if (row < 0 || row > n) throw new IllegalArgumentException("row");
        if (col < 0 || col > n) throw new IllegalArgumentException("col");
    }
    // returns the number of open sites
    public int numberOfOpenSites() {
        return count;
    }


    // does the system percolate?
    public boolean percolates() {

        return (weightedQuickUnionUF.find(n * n) == weightedQuickUnionUF.find(n * n + 1));
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(1);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.weightedQuickUnionUF.find(1);
        percolation.weightedQuickUnionUF.find(2);
    }
}
