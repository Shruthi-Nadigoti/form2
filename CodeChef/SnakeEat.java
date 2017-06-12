import java.io.*;
import java.util.*;
class SnakeEat
{
    public static void main(String[] args) throws IOException
    {
    	try{
    	Scanner obj=new Scanner(System.in);
    	int T=obj.nextInt();
   	for(int i=0;i<T;i++)
   	{
   		String str=obj.next();
   		char[] s=str.toCharArray();
   		for(int j=0;j<s.length;j++)
   		{
   			if(s[j]=='m')
   			{
   			 	if(j-1>=0&&s[j-1]=='s')
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
