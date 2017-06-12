import java.io.*;
import java.util.*;
class s
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
    		int x1=0,x2=0,v=0;
    		for(int j=0;j<n;j++)
    		{
    			if(ch[0][j]=='*')
    				x1=1;
    			if(ch[1][j]=='*')
    				x2=1;
    		}
    		if(x1==1&&x2==1)
    		{
    			v=1;
    		}
    		int state1=0,state=0;
    			if(ch[0][0]=='*'&&ch[1][0]=='*')
    				state1=3;
    			else if(ch[0][0]=='*'&&ch[1][0]=='.')
    				state1=1;
    			else if(ch[0][0]=='.'&&ch[1][0]=='*')
    				state1=2;
    		for(int j=0;j<n-1;j++)
    		{
    			
    			if(ch[0][j+1]=='*'&&ch[1][j+1]=='*')
    				state=3;
    			else if(ch[0][j+1]=='*'&&ch[1][j+1]=='.')
    				state=1;
    			else if(ch[0][j+1]=='.'&&ch[1][j+1]=='*')
    				state=2;
    			else
    				state=0;
   			
   			//System.out.println(state1+"  :"+state);
   			if(state1==0)
   				state1=state;
    			else if(state1==1)
    			{
    				if(state==2)
    					state1=3;
    				else if(state==1)
    				{
    					v++;
    					state1=1;
    				}
    				else if(state==3)
    				{
    					v++;
    					state1=3;
    				}
    			}
    			else if(state1==2)
    			{
    				if(state==1)
    					state1=3;
    				else if(state==3)
    				{
    					v++;
    					state1=3;
    				}
    				else if(state==2)
    				{
    					v++;
    					state1=2;
    				}
    			}
    			else if(state1==3)
    			{
    				if(state==1)
    				{
    					v++;
    					state1=1;
    				}
    				else if(state==3)
    				{
    					v++;
    					state1=3;
    					
    				}
    				else if(state==2)
    				{
    					v++;
    					state1=2;
    				}
    			}
    			//System.out.println(v);
    			
    		}
    		
    		System.out.println(v);
    		
    		
    	}
    	}catch(Exception e)
    	{
    		return;
    	}
    }
  
}
