import java.io.*;
import java.util.*;
 class Valid
{
    public static void main(String[] args) throws IOException
    {
    	try{
        Scanner obj=new Scanner(System.in);
        int T=obj.nextInt();
        int n[]=new int[T];
        for(int i=0;i<T;i++)
        {
        	n[i]=obj.nextInt();
        	int m=obj.nextInt();
        	int arr[][]=new int[m][2];
        	for(int k=0;k<m;k++)
        	{
        		for(int j=0;j<2;j++)
        		{
        			arr[k][j]=obj.nextInt();
        		}
        	}
        }
        for(int i=0;i<T;i++)
        {
           if(n[i]%2==0)
           	System.out.println("yes");
           else
           	System.out.println("no");	
        }
        }catch(Exception e)
        {
        	return;
        }
        
    }
  
}
