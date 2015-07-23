package com.chendoing.learning;

public class WeightedQuickUnionUF {

    private int[] id;
    private int[] size;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            //算法的亮点之处
//             id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }
    
    public int[] getResult(){
        return id;
    }
    
    public static void main(String[] args){
        WeightedQuickUnionUF quickFindUF = new WeightedQuickUnionUF(10);
//        quickFindUF.union(0, 1);
//        quickFindUF.union(0, 4);
//        quickFindUF.union(1, 6);
//        quickFindUF.union(4, 2);
//        quickFindUF.union(9, 7);
//        quickFindUF.union(5, 3);
//        quickFindUF.union(3, 9);
//        quickFindUF.union(9, 4);
//        quickFindUF.union(0, 8);
        quickFindUF.union(0, 0);
        quickFindUF.union(6, 1);
        quickFindUF.union(2, 2);
        quickFindUF.union(8, 3);
        quickFindUF.union(8, 4);
        quickFindUF.union(5, 5);
        quickFindUF.union(6, 6);
        quickFindUF.union(7, 7);
        quickFindUF.union(8, 8);
        quickFindUF.union(9, 9);
        for (int i = 0; i < 10; i++) {
            System.out.print(quickFindUF.getResult()[i]);
        }
    }
}
