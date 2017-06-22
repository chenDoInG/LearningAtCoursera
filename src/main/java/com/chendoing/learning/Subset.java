package com.chendoing.learning;

public class Subset {

    public static void main(String[] args) {

        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        int k = Integer.valueOf(args[0]);
        while (!StdIn.isEmpty()) {
            String tmp = StdIn.readString();
            queue.enqueue(tmp);
        }

        while (k > 0) {
            StdOut.println(queue.dequeue());
            k--;
        }
    }
}
