import java.io.*;
import java.util.*;
class SNCOUP
{
    public static void main(String[] args) throws IOException
    {
    	try{
    	Scanner obj=new Scanner(System.in);
    	int T=obj.nextInt();
    	for(int i=0;i<T;i++)
    	{
    		int n=obj.nextInt();
    		char ch[][]=new char[2][n];
    		int fe[]=new int[n];
    		int v=0;
    		for(int j=0;j<n;j++)
    			fe[j]=0;
    		for(int j=0;j<2;j++)
    		{
    			String str=obj.next();
    			for(int k=0;k<n;k++)
    			{
    				ch[j][k]=str.charAt(k);
    			}
    		}
    		for(int j=0;j<2;j++)
    		{
    			for(int k=0;k<n-1;k++)
    			{
    				if(ch[j][k]=='*'){
    				for(int p=k+1;p<n;p++)
    				{
    					if(fe[p]==1)
    					{
    						break;	
    					}
    					if(ch[j][p]=='*')
    					{
    						fe[p]=1;
    						break;
    					}
    					
    				}
    				}
    			}
    		}
    		if(v!=1)
    		{
    			int c=0;
    			for(int j=0;j<n;j++)
    			{
    				if(ch[0][j]=='*'){
    				if(ch[1][j]=='*')
    				{
    					v=1;
    					break;
    				}
    				for(int k=j+1;k<n;k++)
    				{
    					if(v==1){
    						c=1;
    						break;
    					}
    					if(fe[k]==1)
    						break;
    					else{
    						if(ch[1][k]=='*')
    						{
    							v=1;
    							c=1;
    							break;
    						}
    						}
    					
    					
    				
    				}
    				for(int k=j-1;k>=0;k--)
    				{
    					if(v==1){
    						c=1;
    						break;
    					}
    					if(fe[k+1]==1)
    						break;
    					else{
    						if(ch[1][k]=='*')
    						{
    							v=1;
    							c=1;
    							break;
    						}
    						}
    					
    					
    				
    				}
    				if(c==1)
    					break;
    				}
    			}
    		}
    		int sum=v;
    		//System.out.println(sum);
    		for(int j=0;j<n;j++){
    			sum=sum+fe[j];
    			//System.out.println("fe:"+fe[j]);
    			}
    		System.out.println(sum);
    		
    		
    	}
    	}catch(Exception e)
    	{
    		return;
    	}
    }
  
}
