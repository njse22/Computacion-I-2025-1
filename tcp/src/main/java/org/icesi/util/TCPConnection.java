package org.icesi.util;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// Publisher
public class TCPConnection extends Thread {

    private static TCPConnection instance;

    // suscriber | listener
    private IListener listener;

    private Socket socket;

    private TCPConnection(){}

    public static TCPConnection getInstance(){
        if (instance == null){
            instance = new TCPConnection();
        }
        return instance;
    }

    // addSuscriber
    public void setListener(IListener listener){
        this.listener = listener;
    }

    public void initAsServer(int port){
        try {
            this.socket = new ServerSocket(port).accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initAsClient(String ip, int port){
        try {
            this.socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // notifySuscriber
    @Override
    public void run(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            String message = reader.readLine();

            listener.onMessage(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message, String remoteIP, int remotePort){
        new Thread( () -> {
            try {
                Socket remoteSocket = new Socket(remoteIP, remotePort);
                // Fuente de información
                OutputStream out = remoteSocket.getOutputStream();

                // Empaqueta la información | conecta la fuente de información con
                // el lenguaje JAVA
                OutputStreamWriter osw = new OutputStreamWriter(out);

                // Escritor de la información
                BufferedWriter writer = new BufferedWriter(osw);

                writer.write(message + "\n");
                writer.flush();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    // Suscriber
    @FunctionalInterface
    public interface IListener{
        String onMessage(String message);
    }
}
