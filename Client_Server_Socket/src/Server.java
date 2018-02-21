import java.net.*;
import javax.swing.*;
import java.io.*;

public class Server extends Thread {
private ServerSocket serverSocket;

public  Server(int port) throws IOException
{
	serverSocket=new ServerSocket(port);
	serverSocket.setSoTimeout(100000);
    	
}
public String func(int option){
	String res=null;
	int r;
	int ar;
	String buff=null;
	switch(option){
	     
		case 1:
			r=Integer.parseInt(JOptionPane.showInputDialog("Enter the Radius"));
			ar=r*r*3;
			res=Integer.toString(ar);
			break;
		case 2:	
		    r=Integer.parseInt(JOptionPane.showInputDialog("Enter the Side Length"));
		    ar=r*r;
		    res=Integer.toString(ar);
		    break;
		case 3:
			buff=JOptionPane.showInputDialog("Enter the String");
			res=buff.toUpperCase();
			break;
		case 4:	
			buff=JOptionPane.showInputDialog("Enter the String");
			res=buff.toLowerCase();
			break;
		case 5:	 
			//server.close();
			buff=JOptionPane.showInputDialog("Enter the String");
			int count=0;
			char[] a=buff.toCharArray();
			for(int i=0;i<buff.length();i++){
				if(a[i]=='a'||a[i]=='e'||a[i]=='i'||a[i]=='o'||a[i]=='u'||a[i]=='A'||a[i]=='E'||a[i]=='I'||a[i]=='O'||a[i]=='U')
				{
					count++;
				}
			}
			res=Integer.toString(count);
			break;	
	}
return res;	
} 

public void run(){
	while(true){
		try{
			System.out.println("Waiting for client on port "+serverSocket.getLocalPort()+"...");
			Socket server=serverSocket.accept();
			
			System.out.println("Connected to"+server.getRemoteSocketAddress());
			DataInputStream in=new DataInputStream(server.getInputStream());
			DataOutputStream out=new DataOutputStream(server.getOutputStream());
			JOptionPane.showMessageDialog(null, func(in.readInt()));
		}catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
            break;
		} catch (IOException e) {
            e.printStackTrace();
            break;
         }
	}
}
public static void main(String [] args) {
    int port = Integer.parseInt(args[0]);
    try {
       Thread t = new Server(port);
       t.start();
    } catch (IOException e) {
       e.printStackTrace();
    }
 }
}

