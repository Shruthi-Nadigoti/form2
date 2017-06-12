import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        try{
            //Your Solve
             Scanner obj=new Scanner(System.in);
             int S=obj.nextInt();
             int N[]=new int[S];
             int H[][]=new int[S][];
             for(int i=0;i<S;i++)
             {
                N[i]=obj.nextInt();
                  H[i]=new int[N[i]];
                for(int j=0;j<N[i];j++)
                {
                      
                        H[i][j]=obj.nextInt();
                    
                        
                }
                
             }
           
             if(isValid(S,N,H)){
              
                 for(int i=0;i<S;i++)
                 {
                     
                        if(N[i]%2!=0){
                        int j;
                        for(j=0;j<N[i]/2;j++)
                        {
                              
                                if(H[i][j]!=j+1||H[i][N[i]-j-1]!=j+1)
                                        break;
                        }
                        if(j==N[i]/2)
                                System.out.println("yes");
                         else
                                System.out.println("no");       
                        }
                        else
                                System.out.println("no");
                 }
             }
             else
                System.out.println("Invalid Input");
        }catch(Exception e){
           System.out.println(e.getStackTrace());
        }
    }
    static boolean isValid(int S,int N[],int H[][]){
      if(S<1||S>100)
                return false;
             
       for(int i=0;i<S;i++)
       {
         if(N[i]<3||N[i]>100)
                return false;      
          for(int j=0;j<N[i];j++)
          {
             
                 if(H[i][j]<1||H[i][j]>100)
                        return false;
          }
          
       }
       return true;
    }
}
