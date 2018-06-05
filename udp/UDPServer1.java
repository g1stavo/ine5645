import java.net.*;
import static java.lang.System.out;

public class UDPServer1 {
    public static void main(String[] args) throws Exception {
        out.println("UDP Server");
        DatagramSocket serverSocket = new DatagramSocket(28082);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        int count = 0;

        while(true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String message = new String(receivePacket.getData());
            InetAddress client_ip = receivePacket.getAddress();
            count++;
            int client_port = receivePacket.getPort();            
            out.println("------\nPacket "+count+" received from "+client_ip.getHostAddress()+":"+client_port);
            out.println("Message:\n"+message+"\n------");
            String answer = "Received packet number "+count+" with "+receivePacket.getLength()+" bytes";           
            sendData = answer.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, client_ip, client_port);
            serverSocket.send(sendPacket);
        }
    }
}