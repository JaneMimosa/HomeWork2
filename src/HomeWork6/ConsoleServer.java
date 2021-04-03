package HomeWork6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleServer {
    private static Socket socket;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(6000);
            System.out.println("Server started");
            socket = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }


        new Thread(new Runnable() { // Receive msg
            @Override
            public void run() {
                String line;
                BufferedReader in = null;
                try {
                    in = new BufferedReader(new InputStreamReader(ConsoleServer.socket.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    while ((line = in.readLine()) != null) {
                        if (line.equals("Client disconnected")) {
                            System.out.println("Client: bye");
                            System.out.println(line);
                            break;
                        }
                        System.out.println("Client: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() { // Send Message
            @Override
            public void run() {
                String input;
                PrintWriter out = null;
                try {
                    out = new PrintWriter(ConsoleServer.socket.getOutputStream(), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (!(input = br.readLine()).equals("/end")) {
                        out.println(input);
                    }
                    out.println("Server disconnected");
                    ConsoleServer.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

