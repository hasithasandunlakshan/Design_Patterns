package Structural.Adapter;

interface AdvancedSocket {
    void connect();

    void disconnect();

    void sendData(String data);

    String receiveData();

}

class Socket {
    void connectSocket() {
        System.out.println("Socket Connected");
    }

    void disconnectSocket() {
        System.out.println("Socket Disonnected");
    }

    void sendDataOverSocket(String data) {
        System.out.println("Sending data: " + data);
    }

    String receiveDataOverSocket() {
        return "Received data from socket";
    }

}

class SocketAdapter implements AdvancedSocket {
    private Socket socket;

    public SocketAdapter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void connect() {
        socket.connectSocket();
    }

    @Override
    public void disconnect() {
        socket.disconnectSocket();
    }

    @Override
    public void sendData(String data) {
        socket.sendDataOverSocket(data);
    }

    @Override
    public String receiveData() {
        return socket.receiveDataOverSocket();
    }
}

public class main {
    public static void main(String[] args) {
        Socket socket = new Socket();
        AdvancedSocket advancedSocket = new SocketAdapter(socket);
        advancedSocket.connect();
        advancedSocket.sendData("Hello from client");
        System.out.println("Received data: " + advancedSocket.receiveData());
        advancedSocket.disconnect();
    }

}