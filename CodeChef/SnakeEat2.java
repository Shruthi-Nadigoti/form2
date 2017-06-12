import java.io.*;
import java.util.*;
class SnakeEat2
{
    public static void main(String[] args) throws IOException
    {
    	try{
    	Scanner obj=new Scanner(System.in);
    	int T=obj.nextInt();
    	String str[]=new String[T];
    	for(int i=0;i<T;i++)
    		str[i]=obj.next();
    	
   	for(int i=0;i<T;i++)
   	{
   		
   		char[] s=str[i].toCharArray();
   		for(int j=1;j<s.length;j++)
   		{
   			if(s[j]=='m')
   			{
   			 	if(s[j-1]=='s')
   			 		s[j-1]='o';
   			 	else if(j+1<s.length&&s[j+1]=='s')
   			 		s[j+1]='o';
   			}
   		}
   		int M=0,S=0;
   		for(int k=0;k<s.length;k++)
   		{
   			if(s[k]=='s')
   				S=S+1;
   			if(s[k]=='m')
   				M=M+1;	
   		}
   		//System.out.println(S+"and"+M);
   		if(M>S)
   			System.out.println("mongooses");
   		else if(M<S)
   			System.out.println("snakes");
   		else
   			System.out.println("tie");
   	}
   	}catch(Exception e)
   	{
   		return ;
   	}
    	
    }
  
}
