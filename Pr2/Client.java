package Pr2;

import java.io.IOException;
import java.io.PrintStream;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        PrintStream out = new PrintStream(socket.getOutputStream());
        
        
    }
}