package org.icesi.model;

import org.icesi.util.TCPConnection;

public class ServerTCP implements TCPConnection.IListener {

    public static void main(String[] args) {
        ServerTCP server = new ServerTCP();
        TCPConnection connection = TCPConnection.getInstance();
        connection.initAsServer(5000);
        connection.setListener(server);
        connection.start();
        connection.sendMessage("Hola desde el server",
                "127.0.0.1", 5001);

    }

    @Override
    public String onMessage(String message) {
        System.out.println("MESSAGE: " + message);
        return message;
    }
}
