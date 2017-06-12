import java.io.*;
import java.util.*;
class new1
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
    		int max[][]=new int[m*n][4];
    		int size1=0;
    		for(int j=0;j<n;j++)
    		{
    			for(int k=0;k<m;k++)
    			{
    				if(arr[j][k]>max1){
    					max1=arr[j][k];
    					}				
    			}
    		}
    		
    		for(int j=0;j<n;j++)
    		{
    			for(int k=0;k<m;k++)
    			{
    				if(arr[j][k]==max1){
    					max[size1][0]=j;
    					max[size1][1]=k;
    					max[size1][2]=j;
    					max[size1][3]=k;
    					
    					size1++;
    					}
    			}
    		}
    		
    		
    		
    		int count=0;
    		
    		while(true){
    		
    		for(int j=0;j<size1;j++)
    		{
    			
    			//System.out.println("j:"+max[j][0]+"\t"+max[j][1]+"\t"+max[j][2]+"\t"+max[j][3]+"\n");
    			for(int k=0;k<size1;k++)
    			{
    				if(j==k)
    					continue;
    				//System.out.println("k:"+max[k][0]+"\t"+max[k][1]+"\t"+max[k][2]+"\t"+max[k][3]+"\n");
    				
    				
    				if(max[k][1]==max[j][1]&&max[k][3]==max[j][3]&&max[k][2]+1>=max[j][0]&&max[k][0]<=max[j][0])
    				{
    					if(max[k][0]<max[j][0])
    						max[j][0]=max[k][0];
    					if(max[k][2]>max[j][2])
    						max[j][2]=max[k][2];
    					//max[j][2]=max[k][2];
    					 j--;
    					  max[k][0]=max[size1-1][0];
    					  max[k][1]=max[size1-1][1];
    					  max[k][2]=max[size1-1][2];
    					 max[k][3]=max[size1-1][3];
    					size1--;
    					// System.out.println("top");
    					  break;
    				}
    				if(max[k][0]==max[j][0]&&max[k][2]==max[j][2]&&max[k][1]-1<=max[j][3]&&max[k][3]>=max[j][3])
    				{
    					if(max[k][1]<max[j][1])
    						max[j][1]=max[k][1];
    					if(max[k][3]>max[j][3])
    						max[j][3]=max[k][3];
    				
    					 j--;
    					 max[k][0]=max[size1-1][0];
    					 max[k][1]=max[size1-1][1];
    					  max[k][2]=max[size1-1][2];
    					 max[k][3]=max[size1-1][3];
    					size1--;
    					 //System.out.println("left");
    					  break;
    				}
    				if(max[k][1]==max[j][1]&&max[k][3]==max[j][3]&&max[k][0]-1<=max[j][2]&&max[k][2]>=max[j][2])
    				{
    					if(max[k][2]>max[j][2])
    						max[j][2]=max[k][2];
    					if(max[k][0]<max[j][0])
    						 max[j][0]=max[k][0];
    					 j--;
    					  max[k][0]=max[size1-1][0];
    					  max[k][1]=max[size1-1][1];
    					  max[k][2]=max[size1-1][2];
    					 max[k][3]=max[size1-1][3];
    					size1--;
    					  //System.out.println("down");
    					   break;
    				}
    				if(max[k][0]==max[j][0]&&max[k][2]==max[j][2]&&max[k][3]+1>=max[j][1]&&max[k][1]<=max[j][1])
    				{
    					if(max[k][1]<max[j][1])
    						max[j][1]=max[k][1];
    					if(max[k][3]>max[j][3])
    						max[j][3]=max[k][3];
    					 j--;
    					  max[k][0]=max[size1-1][0];
    					  max[k][1]=max[size1-1][1];
    					  max[k][2]=max[size1-1][2];
    					 max[k][3]=max[size1-1][3];
    					size1--;
    					 //System.out.println("right");
    					  break;
    				}
    				if(max[k][0]>=max[j][0]&&max[k][1]>=max[j][1]&&max[k][2]<=max[j][2]&&max[k][3]<=max[j][3])
    				{
    					max[k][0]=max[size1-1][0];
    					max[k][1]=max[size1-1][1];
    					max[k][2]=max[size1-1][2];
    					max[k][3]=max[size1-1][3];
    					size1--;	
    				}
    				
    			}
    			
    			
    		}
    		
    		if(size1==1)
    			{
    				if(max[0][0]==0&&max[0][1]==0&&max[0][2]==n-1&&max[0][3]==m-1)
    				{
					//System.out.println("in");    					
    					break;
    				}
    				
    			}
    		
    		count++;
    		
    		for(int j=0;j<size1;j++)
    		{
    			if(max[j][0]-1>=0&&max[j][0]-1<n)
    				max[j][0]--;
    			if(max[j][1]-1>=0&&max[j][1]-1<m)
    				max[j][1]--;
    			if(max[j][2]+1>=0&&max[j][2]+1<n)
    				max[j][2]++;
    			if(max[j][3]+1>=0&&max[j][3]+1<m)
    				max[j][3]++;	
    		}
    		/*for(int j=0;j<size1;j++)
    		{
    			System.out.println(max[j][0]+"\t"+max[j][1]+"\t"+max[j][2]+"\t"+max[j][3]+"\n");
    		}
    		System.out.println();*/
    		}
    		System.out.println(count);
    		
    		}
    		
    	}
    	
}
