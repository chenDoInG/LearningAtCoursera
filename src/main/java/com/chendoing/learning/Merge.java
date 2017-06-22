package com.chendoing.learning;

public class Merge {

    private static Comparable[] aux;
    static int N =0;
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        N++;
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable comparable, Comparable comparable2) {

        return comparable.compareTo(comparable2) < 0;
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int mid = lo+(hi-lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }
    
    public static void main(String[] args){
        int[] array = new int[]{52,59,45,79,87,16,66,49,70,29,11,69};
//        sort(array, 0, 11);
    }
}
