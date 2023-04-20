import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        new Server();
    }
    public Server() throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(5000, 50, InetAddress.getByName("0.0.0.0"));
            System.out.println("Sever runs at " + serverSocket.getLocalPort() + " port");

            while(true) {
                Socket socket = serverSocket.accept();
                User clientThread = new User(socket);
                new Thread(clientThread).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}