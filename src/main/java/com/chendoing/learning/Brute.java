package com.chendoing.learning;

import java.util.Arrays;

public class Brute {
    private void solve(Point[] points) {
        int N = points.length;
        for (int i = 0; i < N; i++) {
            Point p = points[i];

            for (int j = i + 1; j < N; j++) {
                Point q = points[j];

                for (int k = j + 1; k < N; k++) {
                    Point r = points[k];
                    double pq = p.slopeTo(q);
                    double pr = p.slopeTo(r);

                    if (pq != pr)
                        continue;

                    for (int m = k + 1; m < N; m++) {
                        Point s = points[m];
                        double ps = p.slopeTo(s);

                        if (pq != ps)
                            continue;
                        // weightedQuickUnionUF.union(i, j);
                        // weightedQuickUnionUF.union(j, k);
                        // weightedQuickUnionUF.union(k, m);
                        p.drawTo(q);
                        q.drawTo(r);
                        r.drawTo(s);
                        StdOut.printf("%s -> %s -> %s -> %s\n", p, q, r, s);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        // String filename = args[0];
        String filename = "collinear/rs1423.txt";
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points[i] = p;
            p.draw();
        }
        Arrays.sort(points);
        Brute brute = new Brute();
        brute.solve(points);
        StdDraw.show(0);
    }
}
