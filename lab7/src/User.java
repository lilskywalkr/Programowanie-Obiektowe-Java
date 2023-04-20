import java.io.*;
import java.net.*;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class User implements Runnable {
    private final Socket clientSocket;

    public User(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public Socket getClientSocket() {
        return this.clientSocket;
    }

    private static boolean timeValidation(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime.parse(time, formatter);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    private static long timeDelay(String timeOne, String timeTwo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Duration duration = Duration.between(LocalTime.parse(timeOne, formatter), LocalTime.parse(timeTwo, formatter));
        return duration.toMillis();
    }

    @Override
    public void run() {
        System.out.println("User connected at " + this.clientSocket.getPort() + " server");

        try {
            PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

            while (true) {
                String notification = in.readLine();
                System.out.println("Notification received from client " + this.clientSocket.getPort() + ": " + notification);

                String time = in.readLine();
                System.out.println("The time for notification to be returned: " + time);

                if (!timeValidation(time)) {
                    out.println("Incorrect time format");
                } else {
                    LocalTime currentTime = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                    String formattedTime = currentTime.format(formatter);

                    Thread.sleep(timeDelay(formattedTime, time));

                    // Send the notification back to the client
                    out.println(notification);
                }
            }
        } catch (IOException e) {
            System.out.println("Error sending/receiving notification: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error in thread delay: " + e.getMessage());
        }
    }
}
