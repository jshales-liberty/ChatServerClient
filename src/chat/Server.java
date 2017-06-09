package chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 3000;

    public static void main(String[] args) throws Exception {
        System.out.println("Server running...");

        // create a socket
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            Socket conn = server.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            DataOutputStream output = new DataOutputStream(conn.getOutputStream());

            String message = input.readLine();
            System.out.println("Received: " + message);
            output.writeBytes(message.toUpperCase());

            conn.close();
        }
    }
}