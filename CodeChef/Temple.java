import java.io.*;
import java.util.*;
 class Temple
{
    public static void main(String[] args) throws IOException
    {
    	try{
    	Scanner obj=new Scanner(System.in);
    	int T=obj.nextInt();
    	int n[]=new int[T];
    	int m[][]=new int[T][];
    	for(int i=0;i<T;i++)
    	{
    		 n[i]=obj.nextInt();
    		 m[i]=new int[n[i]];
    		 for(int j=0;j<n[i];j++)
    		 {
    		 	m[i][j]=obj.nextInt();
    		 }
    	}
    	for(int i=0;i<T;i++)
    	{
    		int len;
    		if(n[i]%2==0)
    			len=n[i]/2;
    		else
    			len=n[i]/2+1;	
    		int c=0,max;
    		for(int h=len;h>0;h--)
    		{
    		max=m[i][n[i]/2];
    		if(n[i]%2==0)
    		{
    			
    			if(m[i][n[i]/2-1]>m[i][n[i]/2])
    			{
    				max=m[i][n[i]/2-1];
    			}
    			
    		}
    		if(max<h)
    			h--;
    		for(int j=0;j<n[i];j++)
    		{
    			
    			int succ=h,count=1,sum=0;
    			
    			if(j+h*2-2<n[i]){
    			
    			if(m[i][j+h-1]>=succ){
    				sum=sum+(m[i][j+h-1]-succ);
    				succ--;
    				for(int k=j+h-2;k>=0;k--)
    				{
    					
    					if(succ==0){
    						break;
    						}
    						
    					if((m[i][k]>=succ) && (m[i][j+2*h-succ-1])>=succ){
    					
    					sum=sum+(m[i][k]-succ);
    					sum=sum+(m[i][j+2*h-succ-1]-succ);
    					succ--;
    					
    					}
    					else
    					{
    						count=0;
    						break;
    					}
    					
    				}
    				
    				}
    				else
    					count=0;
    				}	
    				if(count!=0){
    			
    				c=1;
    				//System.out.println("H value"+h);
    				if(h!=0){
    				for(int p=j-1;p>=0;p--){
    				
    					sum=sum+m[i][p];
    					}
    				for(int p=h*2-1+j;p<n[i];p++)
    				{
    					sum=sum+m[i][p];
    				}	
    				}
    				System.out.println(sum);
    				break;
    				}	
    			
    				
   
    		}
    		if(c==1)
    				break;
    	}
    	}
    	}catch(Exception e)
    	{
    		return;
    	}
    	
    }
}
