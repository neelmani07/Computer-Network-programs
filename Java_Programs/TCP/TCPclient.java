import java.util.*;
import java.net.*;
import java.io.*;
class TCPclient
{
	public static void main(String s[])throws Exception
	{	
	
		Socket sock=new Socket("127.0.0.1",9089);
		System.out.println("enter the file name ");
		BufferedReader bf1= new BufferedReader(new InputStreamReader(System.in));
		String fname=bf1.readLine();
		OutputStream os = sock.getOutputStream();
		PrintWriter pr=new PrintWriter(os,true);
		pr.println(fname);
		InputStream is = sock.getInputStream();
		BufferedReader bf4=new BufferedReader(new InputStreamReader(is));
		String str="";
		while ((str=bf4.readLine())!=null)
		{
			System.out.println(str);
		}
		
	
	
	}
}	
