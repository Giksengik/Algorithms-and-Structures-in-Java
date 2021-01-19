package com.company;

public class QuickUnionUF {
    private int[] id;
    public QuickUnionUF(int N){
        id=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
        }
    }
    private int findRoot(int i){
        while (i != id[i]) i = id[i];
        return i;
    }
    public boolean isConnected(int p,int q){
        return id[p]==id[q];
    }
    public void union(int p,int q){
        id[findRoot(p)]=findRoot(q);
    }
    public static void main(String[] args){
    }
}
