import java.io.IOException;
import java.net.ServerSocket;
import static java.lang.System.out;
 
public class TCPServer {	
	int portNumber = 9999;
	ServerSocket oSocket;

	public TCPServer() {
		try {
			oSocket = new ServerSocket(portNumber);
			out.println("Server created!");
			Connection conn = new Connection(oSocket);
			conn.run();
		} catch (IOException ExecIO) {
			out.println("Error");
		}
	} 
 
	public static void main(String[] args) {
		TCPServer server = new TCPServer();
	}
}