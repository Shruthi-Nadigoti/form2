import java.io.*;
import java.util.*;
class SnakProc{
        public static void main(String args[])throws IOException{
                try{
                Scanner obj=new Scanner(System.in);
                int R=obj.nextInt();
                int Len[]=new int[R];
                String s[]=new String[R];
             
                for(int i=0;i<R;i++)
                {
                        Len[i]=obj.nextInt();
                        s[i]=obj.next();
                }
              
                        for(int i=0;i<R;i++)
                        {
                            
                                int count =1;
                                for(int j=0;j<Len[i];j++)
                                {
                                     
                                        if(s[i].charAt(j)=='H'&&count==1)
                                        {
                                                count=0;
                                        }
                                        else if(s[i].charAt(j)=='H'&&count==0)
                                        {
                                                count=0;
                                                break;
                                        }
                                       else if(s[i].charAt(j)=='T'&&count==0)
                                        {
                                                count=1;
                                        }
                                        else if(s[i].charAt(j)=='T'&&count==1)
                                        {
                                                count=0;
                                                break;
                                        }
                                       
                                         
                                }
                                if(count==0)
                                        System.out.println("Invalid");
                                else
                                        System.out.println("Valid");  
                                        
                                        
                                    
                        }
                
                }
                catch(Exception e)
                {
                   return;
                }
          
                
        }
   
}

