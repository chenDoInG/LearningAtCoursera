public class PointSET {

    private SET<Point2D> points;

    // construct an empty set of points
    public PointSET() {
        points = new SET<Point2D>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return points.isEmpty();
    }

    // number of points in the set
    public int size() {
        return points.size();
    }

    // add the point p to the set(if it is not already in the set)
    public void insert(Point2D p) {
        if (!points.contains(p))
            points.add(p);
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return points.contains(p);
    }

    // draw all of the points to standard draw
    public void draw() {
        for (Point2D p : points)
            StdDraw.point(p.x(), p.y());
    }

    // draw all of the points to standard draw
    public Iterable<Point2D> range(RectHV rect) {
        Queue<Point2D> pointsInRect = new Queue<Point2D>();
        for (Point2D p : points)
            if (rect.contains(p))
                pointsInRect.enqueue(p);
        return pointsInRect;
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        Point2D nearestPoint = null;
        double nearestDist = Double.MAX_VALUE;

        for (Point2D q : points) {
            double dist = p.distanceTo(q);
            if (dist < nearestDist) {
                nearestDist = dist;
                nearestPoint = q;
            }
        }
        return nearestPoint;
    }
}
