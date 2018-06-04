import java.io.*;
import java.net.*;
import static java.lang.System.out;

public class UDPClient1 {

    public static void main(String[] args) throws Exception {

        out.println("UDP Client");

        BufferedReader message = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        String msg = message.readLine();
        sendData = msg.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 28082);

        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String answer = new String(receivePacket.getData());

        out.println("Server answer:\n"+answer);

        clientSocket.close();
    }
}