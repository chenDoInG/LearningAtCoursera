package com.chendoing.learning;

public class QuickFindUF {

    private int[] id;
    
    public QuickFindUF(int N){
        
        id = new int[N];
        
        for (int i = 0; i < N; i++) 
            id[i] = i;
    }
    
    public boolean connected(int p, int q){
        return id[p] == id[q];
    }
    
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pid)
                id[i] = qid;
        }
    }
    
    public int[] getResult(){
        return id;
    }
    public static void main(String[] args){
        QuickFindUF quickFindUF = new QuickFindUF(10);
        quickFindUF.union(4, 5);
        quickFindUF.union(2, 6);
        quickFindUF.union(6, 7);
        quickFindUF.union(2, 5);
        quickFindUF.union(9, 1);
        quickFindUF.union(3, 0);
        for (int i = 0; i < 10; i++) {
            System.out.print(quickFindUF.getResult()[i]);
        }
    }
}
