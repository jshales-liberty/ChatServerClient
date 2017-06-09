package chat;

import java.io.*;
import java.net.*;

public class Client {

    private static final int PORT = 3000;

    public static void main(String args[]) throws Exception {
        System.out.println("client running...");

        while (true) {
            // create socket
            Socket clientSocket = new Socket("localhost", PORT);
            // get user input from console
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(System.in));
            String sentence = stdInput.readLine();

            if (sentence.equals("quit")) {
                break;
            }

            // send data
//            byte[] sendData = sentence.getBytes();
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(sentence + "\n");
System.out.println("send data complete");
            
            // receive data
//            byte[] receiveData = new byte[1024];
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER:" + modifiedSentence + "\n");
            clientSocket.close();
        }
    }
}