package com.chendoing.learning;

public class RedBlackTree {

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node                 root;

    private class Node {

        public Node(String number, boolean color) {
            this.number = number;
            this.color = color;
        }

        String  number;
        Node    left, right;
        boolean color;
    }

    private boolean isRed(Node node) {
        if (node == null)
            return BLACK;
        return RED;
    }

    private Node rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        return right;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void put(String number) {
        root = put(root, number);
        root.color = BLACK;
    }

    private Node put(Node node, String number) {
        if (node == null)
            return new Node(number, RED);
        int cmp = (number + node.number).compareTo(node.number + number);
        if (cmp <= 0)
            node.left = put(node.left, number);
        else if (cmp > 0) {
            node.right = put(node.right, number);
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    public String getNumber(String number) {
        Node node = root;
        while (node != null) {
            int cmp = number.compareTo(node.number);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0) {
                node = node.right;
            } else {
                return node.number;
            }
        }
        return null;
    }

    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = RED;
        return left;
    }

    public String min() {
        return min(root).number;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    public String max() {
        return max(root).number;
    }

    private Node max(Node node) {
        if (node.right == null)
            return node;
        return max(node.right);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node deleteMin() {
        return deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public void delete(String number) {
        root = delete(root, number);
    }

    private Node delete(Node node, String number) {
        if (node == null)
            return null;
        int cmp = number.compareTo(node.number);
        if (cmp < 0)
            node.left = delete(node.left, number);
        else if (cmp > 0) {
            node.right = delete(node.right, number);
        } else {
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }
}
