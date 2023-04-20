import java.io.*;
import java.net.*;
import java.lang.String;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected at " + socket.getPort() + " port");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        BufferedReader userNotification = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader userTime = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("Enter your notification: ");
                String notification = userNotification.readLine();

                if (notification.trim().length() == 0) {
                    throw new Exception("Incorrect input");
                }

                output.write(notification);
                output.newLine();
                output.flush();

                System.out.println("Enter the time in HH:mm format");
                String time = userTime.readLine();

                output.write(time);
                output.newLine();
                output.flush();

                // Wait for response from the server
                String response = input.readLine();
                System.out.println("Server: " + response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
