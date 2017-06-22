package com.chendoing.learning;

public class Point2D implements Comparable<Point2D> {

    private double x;
    private double y;

    // construct the point (x, y)
    public Point2D(double x, double y) {

    }

    // x-coordinate
    public double x() {
        return x;
    }

    // y-coordinate
    public double y() {
        return y;
    }

    // Euclidean distance between two points
    public double distanceTo(Point2D that) {
        return 0;
    }

    // square of Euclidean distance between two points
    public double distanceSquaredTo(Point2D that) {
        return 0;
    }

    // for use in an ordered symbol table
    public int compareTo(Point2D that) {
        return 0;
    }

    // does this point equal that?
    public boolean equals(Object that) {
        return true;
    }

    // draw to standard draw
    public void draw() {

    }

    // string representation
    public String toString() {
        return "";
    }
}
