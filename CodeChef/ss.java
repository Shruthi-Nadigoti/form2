import java.io.*;
import java.util.*;
class ss
{
    public static void main(String[] args) throws IOException
    {
    
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
    		int max[][]=new int[m*n][2];
    		int size1=0,size2=0;
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
    		
    		for(int j=0;j<n;j++)
    		{
    			for(int k=0;k<m;k++)
    			{
    				if(arr[j][k]==max1){
    					max[size1][0]=j;
    					max[size1][1]=k;
    					size1++;
    					}
    			}
    		}
    		
    		for(int j=0;j<n;j++)
    		{
    			for(int p=0;p<m;p++)
    			{
    			if(arr[j][p]!=max1){
    			int min;
    			int x1=Math.abs(j-max[0][0]);
    			int x2=Math.abs(p-max[0][1]);
    			if(x1>x2)
    				min=x1;
    			else
    				min=x2;
    			for(int k=0;k<size1;k++)
    			{
    				//System.out.println(x1+":up"+x2+":"+min);
    				x1=Math.abs(j-max[k][0]);
    				x2=Math.abs(p-max[k][1]);
    				//System.out.println(x1+":"+x2+":"+min);
    				if(x1>x2)
    				{
    					if(x1<min){
    						min=x1;
    						}
    				}
    				else
    				{
    					if(x2<min){
    						min=x2;
    						//System.out.println(x1+":heer"+x2+":"+min);
    						}
    				}
    				//System.out.println(x1+":heer"+x2+":"+min);
    			}
    			if(min>count)
    				count=min;
    			}
    			}
    		}
    		System.out.println(count);
    		
    		}
    		
    		
    	
    	
    	}
    	
}
