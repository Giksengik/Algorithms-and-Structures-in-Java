package com.company;

public class QuickFindUF {
    private int[] id;
    public QuickFindUF(int N){
        id=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
        }
    }
    public boolean isConnected(int p,int q) {
            return(id[p]==id[q]);
    }
    public void connectUnions(int p,int q){
        if(!isConnected(p,q)){
            int valueToChange=id[p];
            for(int i=0;i<id.length;i++){
                if(id[i]==valueToChange) id[i]=id[q];
            }
        }
    }
}
