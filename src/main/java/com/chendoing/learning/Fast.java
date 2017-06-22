package com.chendoing.learning;

import java.util.Arrays;

public class Fast {

    private void solve(Point[] points) {
        int N = points.length;

        Point[] pointsSortByPoint = new Point[N];
        for (int i = 0; i < N; ++i) {
            Point point4sort = points[i];
            for (int j = 0; j < N; ++j)
                pointsSortByPoint[j] = points[j];
            Arrays.sort(pointsSortByPoint,point4sort.SLOPE_ORDER);

            int start = -1;
            int end = -1;
            double prevSlope = 0;

            for (int j = 0; j < N; ++j) {
                Point each = pointsSortByPoint[j];
                double slope = point4sort.slopeTo(each);

                if (start == -1)
                    start = j;
                else if (slope == prevSlope){
                    end = j;
                    if(end == N -1)
                        drawPointsInLine(pointsSortByPoint, point4sort, start, end);
                }
                else {
                    drawPointsInLine(pointsSortByPoint, point4sort, start, end);
                    start = j;
                }

                prevSlope = slope;
            }
        }
    }

    private void drawPointsInLine(Point[] pointsSortByPoint, Point p, int start, int end) {
        if (end - start >= 2 && p.compareTo(pointsSortByPoint[start]) <= 0) {
            printCoordinates4PointsInLine(pointsSortByPoint, p, start, end);
            p.drawTo(pointsSortByPoint[end]);
            StdOut.printf("\n");
        }
    }

    private void printCoordinates4PointsInLine(Point[] pointsSortByPoint, Point p, int start, int end) {
        StdOut.printf("%s", p);
        for (int k = start; k <= end; ++k)
            StdOut.printf(" -> %s", pointsSortByPoint[k]);
    }

    public static void main(String[] args) {
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
//        String filename = args[0];
         String filename = "collinear/rs1423.txt";
        In in = new In(filename);
        int N = in.readInt();

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }
        Arrays.sort(points);
        Fast fast = new Fast();
        fast.solve(points);
        StdDraw.show(0);
    }
}