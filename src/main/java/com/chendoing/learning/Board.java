package com.chendoing.learning;

import java.util.Iterator;

public class Board {

    private int[][] blocks;
    private int     N;

    // construct a board from an N-by-N array of blocks
    public Board(int[][] blocks) {
        N = blocks[0].length;
        this.blocks = new int[N][N];
        for (int i = 0; i < N; ++i) {
            System.arraycopy(blocks[i], 0, this.blocks[i], 0, blocks[i].length);
        }
    }

    // board dimension N
    public int dimension() {
        return N;
    }

    // number of blocks out of place
    public int hamming() {
        int humming = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i * N + j + 1) != blocks[i][j] && blocks[i][j] != 0)
                    humming++;
            }
        }
        return humming;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int manhattan = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (blocks[i][j] != 0) {
                    int k = (blocks[i][j] - 1) / N;
                    int l = (blocks[i][j] - 1) % N;
                    manhattan += Math.abs(i - k) + Math.abs(j - l);
                }
            }
        }
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // a board obtained by exchanging two adjacent blocks in the same row
    public Board twin() {
        int val = 0;
        int twinBlocks[][] = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.arraycopy(this.blocks[i], 0, twinBlocks[i], 0,
                        this.blocks[i].length);
            }
        }

        for (int i = 0; i < N; i++) {
            if (twinBlocks[0][i] == 0) {
                val++;
                break;
            }
        }
        if (val == 0) {
            int tmp = twinBlocks[0][0];
            twinBlocks[0][0] = twinBlocks[0][1];
            twinBlocks[0][1] = tmp;
        } else {
            int tmp = twinBlocks[1][0];
            twinBlocks[1][0] = twinBlocks[1][1];
            twinBlocks[1][1] = tmp;
        }
        Board b = new Board(twinBlocks);
        twinBlocks = null;
        return b;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this)
            return true;
        if (y == null)
            return false;
        if (y.getClass() != this.getClass())
            return false;
        Board that = (Board) y;
        if (this.blocks.length != that.blocks.length)
            return false;
        for (int i = 0; i < N; i++) {
            if (this.blocks[i].length != that.blocks.length)
                return false;
            for (int j = 0; j < N; j++) {
                if (this.blocks[i][j] != that.blocks[i][j])
                    return false;
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> neighborQueue = new Queue<Board>();
        int x = 0, y = 0;
        int tmpBlocks[][];
        Board b;

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (this.blocks[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        tmpBlocks = new int[N][N];
        for (int j = 0; j < N; ++j) {
            System.arraycopy(blocks[j], 0, tmpBlocks[j], 0, blocks[j].length);
        }
        if (x != 0) {
            // down
            tmpBlocks[x][y] = tmpBlocks[x - 1][y];
            tmpBlocks[x - 1][y] = 0;
            b = new Board(tmpBlocks);
            neighborQueue.enqueue(b);
            tmpBlocks[x - 1][y] = tmpBlocks[x][y];
            tmpBlocks[x][y] = 0;
        }
        if (x != N - 1) {
            // up
            tmpBlocks[x][y] = tmpBlocks[x + 1][y];
            tmpBlocks[x + 1][y] = 0;
            b = new Board(tmpBlocks);
            neighborQueue.enqueue(b);
            tmpBlocks[x + 1][y] = tmpBlocks[x][y];
            tmpBlocks[x][y] = 0;
        }
        if (y != 0) {
            // right
            tmpBlocks[x][y] = tmpBlocks[x][y - 1];
            tmpBlocks[x][y - 1] = 0;
            b = new Board(tmpBlocks);
            neighborQueue.enqueue(b);
            tmpBlocks[x][y - 1] = tmpBlocks[x][y];
            tmpBlocks[x][y] = 0;
        }
        if (y != N - 1) {
            // left
            tmpBlocks[x][y] = tmpBlocks[x][y + 1];
            tmpBlocks[x][y + 1] = 0;
            b = new Board(tmpBlocks);
            neighborQueue.enqueue(b);
        }
        tmpBlocks = null;
        b = null;
        return neighborQueue;

    }

    // string representation of the board (in the output format specified below)
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {

        // create initial board from file
        // In in = new In(args[0]);
        // In in = new In("8puzzle/puzzle04.txt");
        // int N = in.readInt();
        // int[][] blocks = new int[N][N];
        // for (int i = 0; i < N; i++)
        // for (int j = 0; j < N; j++)
        // blocks[i][j] = in.readInt();

        int[][] blocks = new int[][] { { 1, 0, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };

        // print solution to standard output
        Board board = new Board(blocks);
        StdOut.println(board);
        StdOut.println(board.hamming());
        StdOut.println(board.manhattan());
        for (Iterator<Board> iterator2 = board.neighbors().iterator(); iterator2
                .hasNext();) {
            StdOut.println(iterator2.next());
        }
    }
}
