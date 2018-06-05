import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class TCPClient {
	InetAddress serverAddress;
	Socket oSocket;
	int port = 9999;
 
	public TCPClient() {
		try {
			serverAddress = InetAddress.getLocalHost();			
			String ipServerAddress = serverAddress.getHostName();			
			oSocket = new Socket(ipServerAddress, port);
			ObjectInputStream ois = new ObjectInputStream(oSocket.getInputStream());
			String response = (String)ois.readUTF();			 
			out.println("Read the message: " + response);
			oSocket.close();
		} catch (UnknownHostException ExecHost) {
			out.println("Error");
		} catch (IOException ExceIO) {
			out.println("Error");
		}
	}
 
	public static void main(String[] args) {
		new TCPClient();
	}
}
 
 