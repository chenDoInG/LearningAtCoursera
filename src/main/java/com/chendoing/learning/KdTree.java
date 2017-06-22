package com.chendoing.learning;

public class KdTree {
    private Node    root;
    private Point2D nearestPoint;

    public KdTree() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        if (root == null)
            return 0;
        return root.N;
    }

    public void insert(Point2D p) {
        Node node = new Node(p);
        root = insert(node);
    }

    public boolean contains(Point2D p) {
        boolean contains = false;
        if (root != null && root.p.equals(p))
            return true;
        if (root != null) {
            if (root.p.x() <= p.x())
                contains = searchLR(root.rt, p, contains);
            else
                contains = searchLR(root.lb, p, contains);
        }
        return contains;
    }

    public void draw() {
        drawVerticalLine(null, root);
    }

    private void drawHorizontalLine(Node parent, Node n) {
        if (n == null)
            return;
        StdDraw.setPenColor(StdDraw.BLUE);
        if (parent.p.x() > n.p.x()) {
            StdDraw.line(parent.rect.xmin(), n.p.y(), parent.p.x(), n.p.y());

        } else {
            StdDraw.line(parent.p.x(), n.p.y(), parent.rect.xmax(), n.p.y());

        }

        drawVerticalLine(n, n.rt);
        drawVerticalLine(n, n.lb);
    }

    private void drawVerticalLine(Node parent, Node n) {
        if (n == null)
            return;
        StdDraw.setPenColor(StdDraw.RED);
        if (n == root) {
            StdDraw.line(n.p.x(), 0, n.p.x(), 1);
            StdDraw.show(40);
        } else {
            if (parent.p.y() > n.p.y()) {

                StdDraw.line(n.p.x(), parent.p.y(), n.p.x(), parent.rect.ymin());
            } else {

                StdDraw.line(n.p.x(), parent.p.y(), n.p.x(), parent.rect.ymax());
            }
        }

        drawHorizontalLine(n, n.rt);
        drawHorizontalLine(n, n.lb);
    }

    public Iterable<Point2D> range(RectHV rect) {
        Queue<Point2D> lista = new Queue<Point2D>();
        if (root == null)
            return lista;
        if (rect.contains(root.p)) {
            lista.enqueue(root.p);
        }
        if (root.p.x() >= rect.xmin() && root.p.x() <= rect.xmax()) {
            rangeLR(root.lb, rect, lista);
            rangeLR(root.rt, rect, lista);
        } else if (root.p.x() > rect.xmin()) {
            rangeLR(root.lb, rect, lista);
        } else {
            rangeLR(root.rt, rect, lista);
        }
        return lista;

    }

    private void rangeLR(Node parent, RectHV rect, Queue<Point2D> lista) {
        if (parent == null || !rect.intersects(parent.rect))
            return;
        if (rect.contains(parent.p))
            lista.enqueue(parent.p);
        if (parent.p.y() >= rect.ymin() && parent.p.y() <= rect.ymax()) {
            rangeBT(parent.lb, rect, lista);
            rangeBT(parent.rt, rect, lista);
        } else if (parent.p.y() > rect.ymin()) {
            rangeBT(parent.lb, rect, lista);
        } else {
            rangeBT(parent.rt, rect, lista);
        }

    }

    private void rangeBT(Node parent, RectHV rect, Queue<Point2D> lista) {
        if (parent == null || !rect.intersects(parent.rect))
            return;
        if (rect.contains(parent.p))
            lista.enqueue(parent.p);
        if (parent.p.x() >= rect.xmin() && parent.p.x() <= rect.xmax()) {
            rangeLR(parent.lb, rect, lista);
            rangeLR(parent.rt, rect, lista);
        } else if (parent.p.x() > rect.xmin()) {
            rangeLR(parent.lb, rect, lista);
        } else {
            rangeLR(parent.rt, rect, lista);
        }
    }

    public Point2D nearest(Point2D p) {

        if (root != null) {
            nearestPoint = root.p;
        } else
            return null;
        if (nearestPoint != null && nearestPoint.equals(p))
            return nearestPoint;
        if (root.lb != null && p.x() <= root.lb.rect.xmax()
                && p.x() >= root.lb.rect.xmin()) {
            nearestLR(root.lb, p);
            if (root.rt != null
                    && root.rt.rect.distanceSquaredTo(p) < nearestPoint
                            .distanceSquaredTo(p))
                nearestLR(root.rt, p);
        } else {
            nearestLR(root.rt, p);
            if (root.lb != null
                    && root.lb.rect.distanceSquaredTo(p) < nearestPoint
                            .distanceSquaredTo(p))
                nearestLR(root.lb, p);
        }

        return nearestPoint;
    }

    private void nearestLR(Node n, Point2D p) {
        if (n == null)
            return;
        if (n.p.distanceSquaredTo(p) < nearestPoint.distanceSquaredTo(p))
            nearestPoint = n.p;
        if (nearestPoint != null && nearestPoint.equals(p))
            return;
        if (n.lb != null && n.lb.rect.ymin() <= p.y()
                && n.lb.rect.ymax() >= p.y()) {
            nearestBT(n.lb, p);
            if (n.rt != null
                    && n.rt.rect.distanceSquaredTo(p) < nearestPoint
                            .distanceSquaredTo(p))
                nearestBT(n.rt, p);
        } else {
            if (n.rt != null)
                nearestBT(n.rt, p);
            if (n.lb != null
                    && n.lb.rect.distanceSquaredTo(p) < nearestPoint
                            .distanceSquaredTo(p))
                nearestBT(n.lb, p);
        }
    }

    private void nearestBT(Node n, Point2D p) {
        if (n == null)
            return;
        if (n.p.distanceSquaredTo(p) < nearestPoint.distanceSquaredTo(p))
            nearestPoint = n.p;
        if (nearestPoint != null && nearestPoint.equals(p))
            return;
        if (n.lb != null && n.lb.rect.xmin() <= p.x()
                && n.lb.rect.xmax() >= p.x()) {
            nearestLR(n.lb, p);
            if (n.rt != null
                    && n.rt.rect.distanceSquaredTo(p) < nearestPoint
                            .distanceSquaredTo(p))
                nearestLR(n.rt, p);
        } else {
            if (n.rt != null)
                nearestLR(n.rt, p);
            if (n.lb != null
                    && n.lb.rect.distanceSquaredTo(p) < nearestPoint
                            .distanceSquaredTo(p))
                nearestLR(n.lb, p);
        }

    }

    private Node insert(Node node) {
        if (root == null) {
            node.rect = new RectHV(0, 0, 1, 1);
            node.N = 1;
            return node;
        }
        if (root.p.equals(node.p))
            return root;

        if (root.p.x() > node.p.x()) {

            root.lb = insertLR(root.lb, node);
            if (root.lb.rect == null) {
                root.lb.rect = new RectHV(0, 0, root.p.x(), 1);
            }
        } else {
            root.rt = insertLR(root.rt, node);
            if (root.rt.rect == null) {
                root.rt.rect = new RectHV(root.p.x(), 0, 1, 1);
            }
        }
        return root;
    }

    private Node insertLR(Node parent, Node n) {
        if (parent == null) {
            root.N++;
            return n;
        }
        if (parent.p.equals(n.p))
            return parent;
        if (parent.p.y() > n.p.y()) {
            parent.lb = insertBT(parent.lb, n);
            if (parent.lb.rect == null) {
                parent.lb.rect = new RectHV(parent.rect.xmin(),
                        parent.rect.ymin(), parent.rect.xmax(), parent.p.y());
            }
        } else {
            parent.rt = insertBT(parent.rt, n);
            if (parent.rt.rect == null) {
                parent.rt.rect = new RectHV(parent.rect.xmin(), parent.p.y(),
                        parent.rect.xmax(), parent.rect.ymax());

            }
        }
        return parent;
    }

    private Node insertBT(Node parent, Node n) {
        if (parent == null) {
            root.N++;
            return n;
        }
        if (parent.p.equals(n.p))
            return parent;

        if (parent.p.x() > n.p.x()) {
            parent.lb = insertLR(parent.lb, n);
            if (parent.lb.rect == null) {
                parent.lb.rect = new RectHV(parent.rect.xmin(),
                        parent.rect.ymin(), parent.p.x(), parent.rect.ymax());

            }
        } else {
            parent.rt = insertLR(parent.rt, n);
            if (parent.rt.rect == null) {
                parent.rt.rect = new RectHV(parent.p.x(), parent.rect.ymin(),
                        parent.rect.xmax(), parent.rect.ymax());

            }
        }
        return parent;
    }

    private boolean searchLR(Node parent, Point2D p, boolean contains) {
        if (contains)
            return true;
        if (parent == null)
            return false;
        if (parent.p.equals(p))
            contains = true;
        else {
            if (parent.p.y() <= p.y())
                contains = searchBT(parent.rt, p, contains);
            else
                contains = searchBT(parent.lb, p, contains);
        }
        return contains;
    }

    private boolean searchBT(Node parent, Point2D p, boolean contains) {
        if (contains)
            return true;
        if (parent == null)
            return false;
        if (parent.p.equals(p))
            contains = true;
        else {
            if (parent.p.x() <= p.x())
                contains = searchLR(parent.rt, p, contains);
            else
                contains = searchLR(parent.lb, p, contains);
        }
        return contains;

    }

    private static class Node {
        private Point2D p;   // the point
        private RectHV  rect; // the axis-aligned rectangle corresponding to
                              // this
                              // node
        private Node    lb;  // the left/bottom subtree
        private Node    rt;  // the right/top subtree
        private int     N;

        private Node(Point2D p) {
            this.p = p;
            N = 1;
        }
    }

}