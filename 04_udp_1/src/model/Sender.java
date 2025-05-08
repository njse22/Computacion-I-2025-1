package model; 

import java.net.DatagramSocket;
import java.net.SocketException;
import java.rmi.UnknownHostException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class Sender {

    public static void main(String[] args) {
    	
	try(DatagramSocket socket = new DatagramSocket()) {

	    String msj = "Hola desde el sender"; 

	    BufferedReader reader = new BufferedReader(
		    new InputStreamReader(System.in));

	    msj = reader.readLine(); 

	    DatagramPacket packet = new DatagramPacket(
		    msj.getBytes(), // Message 
		    msj.length()    // length message 
		    );
	    //					dest. ip     | dest. port  
	    socket.connect(InetAddress.getByName("127.0.0.1"), 5000);
	    // se empaqueta y se le pasa al socket
	    socket.send(packet);

	} catch(Exception e){
	    e.printStackTrace();
	} 



    }
    

}
