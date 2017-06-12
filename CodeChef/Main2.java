import java.io.*;
import java.util.*;

class Main2
{
    public static void main(String[] args) throws IOException
    {
       
            //Your Solve
            try{
             Scanner obj=new Scanner(System.in);
             int T=obj.nextInt();
             int N[]=new int[T];
             int Q[]=new int[T];
             int L[][]=new int[T][];
             int K[][]=new int[T][];
             for(int i=0;i<T;i++)
             {
                N[i]=obj.nextInt();
                L[i]=new int[N[i]];
                Q[i]=obj.nextInt();
                K[i]=new int[Q[i]];
                for(int j=0;j<N[i];j++)
                {
                        L[i][j]=obj.nextInt(); 
                        
                }
                 for(int j=0;j<Q[i];j++)
                {
                        K[i][j]=obj.nextInt(); 
                        
                }
                
             }
          
             if(isValid(T,N,Q,L,K)){
              
                 for(int i=0;i<T;i++)
                 {
                    quicksort(L,0,N[i]-1,i);
                     for(int j=0;j<Q[i];j++)
                     {
                        int count=N[i];
                        if(count>=2){
                            int k=count-2;
                            while(k-1>=0&&L[i][k-1]<K[i][j])
                            {
                              k--;
                            }
                                if(++L[i][k]==K[i][j])
                                        System.out.println(k+1);
                                 else
                                        System.out.println(k);        
                          }
                     }
                 }
             }
             else
                System.out.println("Invalid Input");
       }
       catch(Exception e)
       {
                return ;
       }
    }
  
    static void quicksort(int[][] A, int p, int r,int k) {
    if (p < r) {
        int q = partition(A, p, r,k);
        quicksort(A, p, q,k);
        quicksort(A, q + 1, r,k);
    }
}

static int partition(int[][] A, int p, int r,int k) {
    int x = A[k][p]; // pivot
    int i = p;
    int j = r;
    while (true) {

        while (A[k][i] > x) {
            i++;
        }

        while (A[k][j] < x) {
            j--;
        }
        if (i < j) {
            int temp = A[k][i];
            A[k][i] = A[k][j];
            A[k][j] = temp;
        } else {
            return j;
        }
    }
}
    static boolean isValid(int T,int N[],int Q[],int L[][],int K[][]){
      if(T<1||T>5)
                return false;
             
       for(int i=0;i<T;i++)
       {
         if(N[i]<1||N[i]>100000||Q[i]<1||Q[i]>100000)
                return false;      
          for(int j=0;j<N[i];j++)
          {
             
                 if(L[i][j]<1||L[i][j]>1000000000)
                        return false;
          }
            for(int j=0;j<Q[i];j++)
          {
             
                 if(K[i][j]<1||K[i][j]>1000000000)
                        return false;
          }
          
       }
       return true;
    }
}
