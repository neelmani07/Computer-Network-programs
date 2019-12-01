import java.util.*;
class CRC
{
	public static int[] calCRC(int totalSize,int messageWithZeroAp[])
	{
		int generatorA[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
		int gCount=0;
		
		for (int i=0;i<totalSize;i++)
		{
			if(messageWithZeroAp[i]== generatorA[0])
			{
				for( int j=i;j<generatorA.length+i;j++)
				{
					messageWithZeroAp[j]=messageWithZeroAp[j] ^ generatorA[gCount++];
				}
				gCount=0;
			}
		}
		return messageWithZeroAp;
	}
	public static void main(String a[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the code meassage size");
		int mSize=sc.nextInt();
		int j=0;
		int cMess[]=new int[mSize];
		int cMessWidZeroAp[]=new int[mSize+16];
		
		System.out.println("enter the code meassage ");
		for(int i=0;i<mSize;i++)
		{
			cMess[i]=sc.nextInt();
		}
		
		for(int i=0;i<mSize;i++,j++)
		{
			cMessWidZeroAp[j]=cMess[i];
		
		}
		for(int i=0;i<16;i++)
		{
			cMessWidZeroAp[j++]=0;
		
		}
		System.out.println("CRC generated is :-");
		int resultToTra[]=new int[j+1];
		int RMess[]=new int[j+1];
		resultToTra=calCRC(mSize,cMessWidZeroAp);
		for(int i=0;i<j;i++)
		{
			System.out.print(resultToTra[i]);
		}
		System.out.println("enter the transmitted msg?");
		
		for(int i=0;i<j;i++)
		{
			RMess[i]=sc.nextInt();
		}
		int result[]=new int[j+1];
		result=calCRC(mSize,RMess);
		int flag=0;
		for(int i=0;i<j;i++)
		{
			if(result[0]==0)
				flag=0;
			else 
			{
				flag=1;
				break;
			}
		}
		if (flag == 0)
		{
			System.out.println("no error");
		}
		else 
		{
			System.out.println("error");
		}
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
