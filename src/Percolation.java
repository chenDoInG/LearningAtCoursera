public class Percolation {

    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF backwash;
    // 0 is block, 1 is open
    private boolean[]            array;
    private int                  N;

    public Percolation(int N) {
        array = new boolean[(N + 1) * N + N + 1];
        this.N = N;
        uf = new WeightedQuickUnionUF((N + 1) * N + N + 1);
        backwash = new WeightedQuickUnionUF(N * N + N + 1);

        for (int i = 1; i <= N; i++) {
            uf.union(0 * N + 1, 0 * N + i);
            backwash.union(0 * N + 1, 0 * N + i);
            array[0 * N + i] = true;
            uf.union((N + 1) * N + 1, (N + 1) * N + i);
            array[(N + 1) * N + i] = true;
        }
    }

    public void open(int i, int j) {
        if (i < 1 || i > N) {
            throw new IndexOutOfBoundsException("row index " + i
                    + " out of bounds");
        }
        if (j < 1 || j > N) {
            throw new IndexOutOfBoundsException("column index " + j
                    + " out of bounds");
        }

        if (array[i * N + j])
            return;
        array[i * N + j] = true;
        if (array[(i - 1) * N + j]) {
            uf.union(i * N + j, (i - 1) * N + j);
            backwash.union(i * N + j, (i - 1) * N + j);
        }
        if (array[(i + 1) * N + j]) {
            uf.union(i * N + j, (i + 1) * N + j);
            if (i != N) {
                backwash.union(i * N + j, (i + 1) * N + j);
            }
        }

        if (j != 1 && array[i * N + j - 1]) {
            uf.union(i * N + j, i * N + j - 1);
            backwash.union(i * N + j, i * N + j - 1);
        }
        if (j != N && array[i * N + j + 1]) {
            uf.union(i * N + j, i * N + j + 1);
            backwash.union(i * N + j, i * N + j + 1);
        }
    }

    public boolean isOpen(int i, int j) {
        if (i < 1 || i > N) {
            throw new IndexOutOfBoundsException("row index " + i
                    + " out of bounds");
        }
        if (j < 1 || j > N) {
            throw new IndexOutOfBoundsException("column index " + j
                    + " out of bounds");
        }
        return array[i * N + j];
    }

    public boolean isFull(int i, int j) {
        if (i < 1 || i > N) {
            throw new IndexOutOfBoundsException("row index " + i
                    + " out of bounds");
        }
        if (j < 1 || j > N) {
            throw new IndexOutOfBoundsException("column index " + j
                    + " out of bounds");
        }
        return backwash.connected(i * N + j, 0 * N + 1) && array[i * N + j];

    }

    public boolean percolates() {
        return uf.connected(0 * N + 1, (N + 1) * N + 1);
    }
}
