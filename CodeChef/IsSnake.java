import java.io.*;
import java.util.*;
class IsSnake
{
    public static void main(String[] args) throws IOException
    {
    	try{
        Scanner obj=new Scanner(System.in);
        int T=obj.nextInt();
        int n[]=new int[T];
        String m[]=new String[2*T];
        int j=0;
        for(int i=0;i<T;i++)
        {
        	n[i]=obj.nextInt();
        	m[j++]=obj.next();
        	m[j++]=obj.next();
        	
        }
     
        for(int i=0;i<T;i++)
        {
        	int states=0;
        	int k=0;
        	   for(j=0;j<n[i];j++){
        	   	if(m[2*i].charAt(j)=='#')
        	   	{
        	   		states=1;
        	   		k=j;
        	   	}
        	   	if(m[2*i+1].charAt(j)=='#')
        	   	{
        	   		states=states+2;
        	   		k=j;
        	   	}
        	   	if(states!=0)
        	   		break;
        	   }
        	   boolean flag=false;
        	  
        	   if(states==1)
        	   {
        	   	
        	   	flag=IsThere(m,2*i,k,"up","up");
        	   	
        	   }
        	   else if(states==2)
        	   {
        	   	
        	   	flag=IsThere(m,(2*i)+1,k,"down","down");
        	   	
        	   }
        	   else if(states==3)
        	   {
        	   
        	   	if(IsThere(m,2*i,k,"up","up")||IsThere(m,(2*i)+1,k,"down","down"))
        	   		flag=true;
        	   	
        	   }
        	   if(flag)
        	   	System.out.println("yes");
        	   else
        	   	System.out.println("no");	
        	   
        }
        }catch(Exception e)
        {
        	return;
        }
        
    }
     static boolean IsThere(String[] m,int i,int index,String pre,String cur){
    		int j;
    		
      		for( j=index;j<m[i].length();j++)
      		{
      			if(pre=="up")
      			{
      				if(cur=="up")
      				{
      					if(m[i+1].charAt(j)=='#')
      					{
      						pre=cur;
      						cur="down";j--;i++;
      						
      					}
      					else if(j+1<m[i].length()&&m[i].charAt(j+1)=='#')
      					{
      						pre=cur;
      						cur="up";	
      						
      					}
      					else
      						break;
      				}
      				else
      				{
      					if(j+1<m[i].length()&&m[i].charAt(j+1)=='#')
      					{
      						pre=cur;
      						cur="down";
      						
      					}
      					else 
      						break;
      					
      				}
      			}
      			else
      			{
      				if(cur=="up")
      				{
      					if(j+1<m[i].length()&&m[i].charAt(j+1)=='#')
      					{
      						pre=cur;
      						cur="up";
      						
      					}
      					else 
      						break;
      				}
      				else
      				{
      					if(m[i-1].charAt(j)=='#')
      					{
      						pre=cur;
      						cur="up";i--;j--;
      						
      					}
      					else if(j+1<m[i].length()&&m[i].charAt(j+1)=='#')
      					{
      						pre=cur;
      						cur="down";	
      						
      					}
      					else
      						break;
      					
      				}
      				
      			}
      		}
      		
      		boolean flag=true;
      		for(int p=j+1;p<m[i].length();p++)
      		{
      			if(i%2==0){
      				
      				if(m[i].charAt(p)=='#'||m[i+1].charAt(p)=='#'){
      					flag=false;
      				
      				}	
      				}else
      				{
      				
      				if(m[i].charAt(p)=='#'||m[i-1].charAt(p)=='#'){
      					flag=false;	
      				}
      				}
      		}
      		
      		return flag;
    }
  
}
