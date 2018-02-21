import java.net.*;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
public class Client {

	

	public static int choice(){
	int coi;	
	System.out.println("Enter a Choice");
	Scanner scanner=new Scanner(System.in);
	return coi=scanner.nextInt();
	

	}
	
	public static String getStr(){
		String st;
		System.out.println("Enter A String");
		Scanner scanner=new Scanner(System.in);
		return st=scanner.nextLine();
	}
	public static int getI(){
		int val;
		System.out.println("Enter a value");
		Scanner scanner=new Scanner(System.in);
		return val=scanner.nextInt();
	}
	public static void main(String [] args){
		String serverName=null;
		try{
			 serverName=args[0];
		}catch (ArrayIndexOutOfBoundsException e) {
	         e.printStackTrace();
	}
		int port =Integer.parseInt(args[1]);
		try{
			System.out.println("Connecting to "+serverName+" on port "+port);
			Socket client=new Socket(serverName,port);
			InetAddress addr = InetAddress.getLocalHost();
	        String ipAddress = addr.getHostAddress();    
			System.out.println(" Just Connected to "+client.getRemoteSocketAddress()+" having ip addess as "+ipAddress);
			
			OutputStream outToServer=client.getOutputStream();
			DataOutputStream out=new DataOutputStream(outToServer);
			String[] options = new String[] {"1-Area of Circle", "2-Area of Rectangle", "3-Uppercase", "4-Lowercase","5-Count Vowels"};
		    int response = Integer.parseInt(JOptionPane.showInputDialog(options));
			
			out.writeInt(response);
		} catch (IOException e) {
	         e.printStackTrace();
	}
}}
