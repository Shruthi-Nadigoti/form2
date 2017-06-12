import java.io.*;
import java.util.*;
class SnakeSocial
{
    public static void main(String[] args) throws IOException
    {
    	try{
    	Scanner obj=new Scanner(System.in);
    	int T=obj.nextInt();
    	for(int i=0;i<T;i++)
    	{
    		int n=obj.nextInt();
    		int m=obj.nextInt();
    		int arr[][]=new int[n][m];
    		
    		for(int j=0;j<n;j++)
    		{
    			for(int k=0;k<m;k++)
    			{
    				arr[j][k]=obj.nextInt();
    			}
    		}
    		
    		int max1=arr[0][0];
    		for(int j=0;j<n;j++)
    		{
    			for(int k=0;k<m;k++)
    			{
    				if(arr[j][k]>max1){
    					max1=arr[j][k];
    					}
    			}
    		}
    		int count=0;
    		
    		while(!isValid(arr,m,n,max1))
    		{
    			
    			int arr2[][]=new int[n][m];
    			for(int j=0;j<n;j++)
    			{
    			for(int k=0;k<m;k++)
    			{
    				int max=arr[j][k];
    				if(k-1>=0&&k-1<m&&arr[j][k-1]>max)
    					max=arr[j][k-1];
    				if(k+1>=0&&k+1<m&&arr[j][k+1]>max)
    					max=arr[j][k+1];
    				if(j-1>=0&&j-1<n&&arr[j-1][k]>max)
    					max=arr[j-1][k];
    				if(j+1>=0&&j+1<n&&arr[j+1][k]>max)
    					max=arr[j+1][k];
    				if(j-1>=0&&j-1<n&&k-1>=0&&k-1<m&&arr[j-1][k-1]>max)
    					max=arr[j-1][k-1];
    				if(j-1>=0&&j-1<n&&k+1>=0&&k+1<m&&arr[j-1][k+1]>max)
    					max=arr[j-1][k+1];
    				if(j+1>=0&&j+1<n&&k-1>=0&&k-1<m&&arr[j+1][k-1]>max)
    					max=arr[j+1][k-1];
    				if(j+1>=0&&j+1<n&&k+1>=0&&k+1<m&&arr[j+1][k+1]>max)
    					max=arr[j+1][k+1];

    				arr2[j][k]=max;
    			}
    			
    		
    			}
    			arr=arr2;
    			/*for(int j=0;j<n;j++)
    			{
    			for(int k=0;k<m;k++)
    			{
    				
    					System.out.print(arr[j][k]);
    			}
    			System.out.println();
    			}*/
    			
    			count++;	
    		}
    		System.out.println(count);
    		
    	}
    	}catch(Exception e)
    	{
    		return;
    	}
    	}
    	static boolean isValid(int arr[][],int m,int n,int max){
    		for(int j=0;j<n;j++)
    		{
    			for(int k=0;k<m;k++)
    			{
    				
    				if(arr[j][k]<max)
    					return false;
    			}
    		
    		}
    		
    		return true;
    		
    	}
    	
    
  
}
