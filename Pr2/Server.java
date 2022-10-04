package Pr2;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    try {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started");
    }
    catch (IOException e) {
        fail(e, "Не удалось запустить сервер");
    }
    public static void fail(IOException e, String str) {
        System.out.println(str + '.' + e);
    }

}
