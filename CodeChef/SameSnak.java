import java.io.*;
import java.util.*;
class SameSnak{
        public static void main(String args[])throws IOException{
              try{
                Scanner obj=new Scanner(System.in);
                int T=obj.nextInt();
                int C[][]=new int[2*T][4];
                for(int i=0;i<2*T;i++){
                        C[i]=new int[4];
                        for(int j=0;j<4;j++)
                        {
                               C[i][j]=obj.nextInt(); 
                        }
                }
                int j=0;
                for(int i=0;i<2*T;i=i+2)
                {
                       int flag1=3;int flag2=3;
                                if(C[i][j+1]==C[i][j+3])
                                        flag1=0;
                                else if(C[i][j]==C[i][j+2])
                                {
                                        flag1=1;
                                }        
                               if(C[i+1][j+1]==C[i+1][j+3])  
                                        flag2=0;
                                else if(C[i+1][j]==C[i+1][j+2])
                                {
                                        flag2=1;
                                }           
                               if(flag1==0&&flag2==0&&C[i+1][j+1]==C[i][j+1])
                               {
                                        int temp1=C[i][j];
                                        int temp2=C[i+1][j];
                                        if(C[i][j]>C[i][j+2])
                                                temp1=C[i][j+2];
                                         if(C[i+1][j]>C[i+1][j+2])
                                                temp2=C[i+1][j+2];          
                                         if(temp1<temp2)
                                         {
                                                if(temp1==C[i][j])
                                                 {
                                                        if(temp2<=C[i][j+2])
                                                                System.out.println("yes");
                                                         else 
                                                                System.out.println("no");        
                                                 }
                                                 else
                                                 {
                                                         if(temp2<=C[i][j])
                                                                System.out.println("yes");
                                                         else 
                                                                System.out.println("no");    
                                                 }
                                                  
                                         }
                                         else
                                         {
                                              
                                                if(temp2==C[i+1][j])
                                                 {
                                                        if(temp1<=C[i+1][j+2])
                                                                System.out.println("yes");
                                                         else 
                                                                System.out.println("no");        
                                                 }
                                                 else
                                                 {
                                                         if(temp1<=C[i+1][j])
                                                                System.out.println("yes");
                                                         else 
                                                                System.out.println("no");    
                                                 }
                                         }       
                               }  
                               else if((flag1==0&&flag2==1)||(flag1==1&&flag2==0))
                               {
                                         if((C[i][j]==C[i+1][j]&&C[i][j+1]==C[i+1][j+1])||(C[i][j]==C[i+1][j+2]&&C[i][j+1]==C[i+1][j+3])||(C[i][j+2]==C[i+1][j]&&C[i][j+3]==C[i+1][j+1])||(C[i][j+2]==C[i+1][j+2]&&C[i][j+3]==C[i+1][j+3]))
                                                   System.out.println("yes");
                                                else
                                                {
                                                        System.out.println("no");
                                                }
                               }
                               else if(flag1==1&&flag2==1&&C[i][j]==C[i+1][j])
                               {
                                        int temp1=C[i][j+1];
                                        int temp2=C[i+1][j+1];
                                        if(C[i][j+1]>C[i][j+3])
                                                temp1=C[i][j+3];
                                         if(C[i+1][j+1]>C[i+1][j+3])
                                                temp2=C[i+1][j+3];          
                                         if(temp1<temp2)
                                         {
                                                if(temp1==C[i][j+1])
                                                 {
                                                        if(temp2<=C[i][j+3])
                                                                System.out.println("yes");
                                                         else 
                                                                System.out.println("no");        
                                                 }
                                                 else
                                                 {
                                                         if(temp2<=C[i][j+1])
                                                                System.out.println("yes");
                                                         else 
                                                                System.out.println("no");    
                                                 }
                                         }
                                         else
                                         {
                                              
                                                if(temp2==C[i+1][j+1])
                                                 {
                                                        if(temp1<=C[i+1][j+3])
                                                                System.out.println("yes");
                                                         else 
                                                                System.out.println("no");        
                                                 }
                                                 else
                                                 {
                                                         if(temp1<=C[i+1][j+1])
                                                                System.out.println("yes");
                                                         else 
                                                                System.out.println("no");    
                                                 }
                                         }       
                               }
                               else
                                        System.out.println("no");          
                                
                                        
                }
                
             }catch(Exception e)
             {
                return ;
             }
                
        }
   
}

