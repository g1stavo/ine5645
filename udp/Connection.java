import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import static java.lang.System.out;

public class Connection extends Thread {
	private ServerSocket oSocket;

	public Connection(ServerSocket oSocket){
		this.oSocket = oSocket;		
	}

	public void run(){
		try {
			Socket sock = oSocket.accept();
			out.println("Sending message!");
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			oos.writeUTF("Server message");
			oos.close();
			sock.close();
		} catch (IOException ExecIO) {
			out.println("Error");
		}
	}
}
