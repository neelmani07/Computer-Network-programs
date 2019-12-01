import java.util.*;
import java.net.*;
import java.io.*;
class TCPserver
{
	public static void main(String s[]) throws Exception
	{	
		ServerSocket servsock=new ServerSocket(9089);
		System.out.println("server ready");
		Socket sock= servsock.accept();
		System.out.println("connection established.  ready to serve ");
		InputStream is = sock.getInputStream();
		BufferedReader bf2=new BufferedReader(new InputStreamReader(is));
		String fname=bf2.readLine();
		BufferedReader bf3=new BufferedReader(new FileReader(fname));
		OutputStream os = sock.getOutputStream();
		PrintWriter pr=new PrintWriter(os,true);
		String str="";
		while((str=bf3.readLine())!= null)
		{
			pr.println(str);
		}
		servsock.close();
		sock.close();
		bf2.close();
		bf3.close();
		pr.close();
		
	
	
	}	
}
