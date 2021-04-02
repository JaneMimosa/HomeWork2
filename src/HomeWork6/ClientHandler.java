package HomeWork6;

import java.io.*;
import java.net.Socket;

public class ClientHandler {
    private static Socket socket;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 6000);
            System.out.println("Connected to server");
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {  // receive
            @Override
            public void run() {
                String line;
                BufferedReader in = null;
                try {
                    in = new BufferedReader(new InputStreamReader(ClientHandler.socket.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                        while ((line = in.readLine()) != null) {
                            if (line.equals("Server disconnected")) {
                                System.out.println("Server: bye");
                                System.out.println(line);
                                break;
                            }
                            System.out.println("Server: " + line);
                        }
                    } catch(IOException e){
                        e.printStackTrace();
                    }
                }
        }).start();

        new Thread(new Runnable() { // Send
            @Override
            public void run() {
                String input;
                PrintWriter out = null;
                try {
                    out = new PrintWriter(ClientHandler.socket.getOutputStream(), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (!(input = br.readLine()).equals("/end")) {
                        out.println(input);
                    }
                    out.println("Client disconnected");
                    ClientHandler.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
