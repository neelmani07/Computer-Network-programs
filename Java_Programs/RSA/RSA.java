import java.util.*;
import java.lang.*;
class RSA
{
	public static int gcd(int x, int y)
	{
		if(y==0)
		{
			//System.out.println(x);
			return x;
		}
		return gcd(y,x%y);
	}
	
	public static int findPublicKey(int fi)
	{	int pK=1;
		
		for(int i=2;;i++)
		{
			if(gcd(fi,i)==1)
			{	pK=i;
				//System.out.println("pK="+pK);
				return pK;
			}
		}
		
	}
	public static int findPrivateKey(int E,int fi)
	{	
		for(int i=2;;i++)
		{
			if((E*i-1)%fi==0)
			{	
				//System.out.println(i);
				return i;
			}
		}
	}
	public static void encryptADisp(String mssg, int E,int n,int a[])
	{	System.out.println("encrypted message to b transmitted.");int l=1;
		for(int i=0;i<mssg.length();i++,l=1)
		{	//System.out.print(mssg.charAt(i));
			int x=(int)mssg.charAt(i);
			//System.out.println(x);
			for (int k=1;k<=E;k++)
				l=(l*x)%n;
			//a[i]=(int)(Math.pow(x,E))%n;
			a[i]=l;
			//System.out.print(a[i]+",");
			System.out.print(a[i]);
			
		}
		System.out.println();
	}
	public static void decryptADisp(String mssg, int D,int n,int a[])
	{	System.out.println("decrypted msg");int l=1;
		for(int i=0;i<mssg.length();i++,l=1)
		{	for (int k=1;k<=D;k++)
				l=(l*a[i])%n;
			char x=(char)(l);
			System.out.print(x);
		}
	}	
	
	public static void main(String str[])
	{	int a[]=new int[100];
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value of p & q such that p*q > largest chararter to b transmitted.");
		int p=sc.nextInt();
		int q=sc.nextInt();
		sc.nextLine();
		System.out.println("enter the message to b transmitted.");
		String msg=sc.nextLine();
		int phi=(p-1)*(q-1);
		int e=findPublicKey(phi);
		//System.out.println(e);
		int d=findPrivateKey(e,phi);
		//System.out.println(d);
		encryptADisp(msg,e,p*q,a);
		decryptADisp(msg,d,p*q,a);
		
	}
}

	
		
		
		
		
		
		
		
		
		
