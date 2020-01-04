package lesson4.using_swing_utilities.server.core;

public class ChatServer {
    public void start(int port) {
        System.out.println("Server started at port: " + port);
    }

    public void stop() {
        System.out.println("Server stopped");
    }
}
