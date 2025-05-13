package org.icesi.model;

import org.icesi.util.TCPConnection;

public class ClientTCP implements TCPConnection.IListener {
    public static void main(String[] args) {

        ClientTCP client = new ClientTCP();
        TCPConnection connection = TCPConnection.getInstance();
        //connection.initAsClient("127.0.0.1", 5000);
        connection.sendMessage("Hola desde el Cliente ",
                "127.0.0.1", 5000);
        connection.setListener(client);

        connection.initAsServer(5001);
        connection.start();

    }

    @Override
    public String onMessage(String message) {
        System.out.println(message);
        return "";
    }
}
