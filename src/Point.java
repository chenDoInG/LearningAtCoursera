import java.util.Arrays;
import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope to this point
    public final Comparator<Point> SLOPE_ORDER;

    private final int              x;
    private final int              y;

    // construct the point (x, y)
    public Point(int x, int y) {

        this.x = x;
        this.y = y;
        SLOPE_ORDER = new SlopeOrder(this);
    }

    // draw this point
    public void draw() {
        StdDraw.point(x, y);
    }

    // draw the line segment from this point to that point
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // is this point lexicographically smaller than that point?
    public int compareTo(Point that) {
        if (this.y == that.y && this.x == that.x)
            return 0;
        if (this.y < that.y || this.y == that.y && this.x < that.x)
            return -1;
        return 1;
    }

    // the slope between this point and that point
    public double slopeTo(Point that) {
        double dy = that.y - this.y;
        double dx = that.x - this.x;
        if (dy == 0 && dx == 0)
            return Double.NEGATIVE_INFINITY;
        if (dx == 0 && dy != 0)
            return Double.POSITIVE_INFINITY;
        if (dy == 0 && dx != 0)
            return 0.0;
        return (double) (dy / dx);
    }

    private class SlopeOrder implements Comparator<Point> {
        private Point base;

        private SlopeOrder(Point base) {
            this.base = base;
        }

        public int compare(Point v, Point w) {
            double s1 = base.slopeTo(v);
            double s2 = base.slopeTo(w);
            if (s1 < s2)
                return -1;
            if (s1 > s2)
                return 1;
            // return v.compareTo(w);
            return 0;
        }
    }

    public static void main(String[] args) {
//        StdDraw.setXscale(0, 20);
//        StdDraw.setYscale(0, 20);

        // read in the input
//        String filename = args[0];
//        // String filename = "input8.txt";
//        In in = new In(filename);
//        int N = in.readInt();
//        Point[] points = new Point[N];
//        for (int i = 0; i < N; i++) {
//            int x = in.readInt();
//            int y = in.readInt();
//            points[i] = new Point(x, y);
//            points[i].draw();
//        }
//        for (int i = 0; i < points.length; i++) {
//            StdOut.printf("%s ", points[i]);
//        }
//        StdOut.println();
//        Arrays.sort(points, 0, N - 1, points[0].SLOPE_ORDER);
//        for (int i = 0; i < points.length; i++) {
//            StdOut.printf("%s ", points[i]);
//        }
        
//        Point a1 = new Point(0, 7);
//        Point a2 = new Point(16, 7);
//        a1.drawTo(a2);
//        
//        Point b1 = new Point(0, 7);
//        Point b2 = new Point(16, 7);
//        b1.drawTo(b2);
//        
//        Point c1 = new Point(14, 6);
//        Point c2 = new Point(14, 18);
//        c1.drawTo(c2);
//        
//        Point d1 = new Point(9, 4);
//        Point d2 = new Point(9, 11);
//        d1.drawTo(d2);
//        
//        Point e1 = new Point(18, 17);
//        Point e2 = new Point(18, 19);
//        e1.drawTo(e2);
//        
//        Point f1 = new Point(11, 13);
//        Point f2 = new Point(19, 13);
//        f1.drawTo(f2);
//        
//        Point g1 = new Point(8, 8);
//        Point g2 = new Point(10, 8);
//        g1.drawTo(g2);
//        
//        Point h1 = new Point(3, 3);
//        Point h2 = new Point(15, 3);
//        h1.drawTo(h2);
        // display to screen all at once
//        StdDraw.show(0);
        
    }
}