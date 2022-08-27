import java.io.*;
import java.net.*;
import java.util.Date;

class UDPClient {
    
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        System.out.println("Digite a mensagem que sera enviada para o servidor: ");
        String sentence = inFromUser.readLine();        
        sendData = sentence.getBytes();
        DatagramPacket sendPacket =
        new DatagramPacket(sendData, sendData.length, IPAddress, 12345);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket =
        new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence =
        new String(receivePacket.getData());
        System.out.println("Resposta do servidor:" + modifiedSentence);
        clientSocket.close();
    }
 
}