package Bai2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 5555;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter username: ");
            String username = userInput.readLine();
            serverOut.println(username);

            // Nhận tin nhắn chào mừng từ server
            String welcomeMessage = serverIn.readLine();
            System.out.println(welcomeMessage);

            // Nhập và gửi tin nhắn cho server
            String message;
            while (true) {
                message = userInput.readLine();
                serverOut.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
