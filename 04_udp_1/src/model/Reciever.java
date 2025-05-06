package model; 

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Reciever {

    public static void main(String[] args) {
        
	//                                            dest. port 
	//                              se habilita un puerto para la 
	//                              escucha de información 
	try(DatagramSocket socket = new DatagramSocket(5000)){

	    // se define una estructura para guardar la información
	    byte[] buffer = new byte[1024]; 

	    // definen el paquete donde se guarda el mensaje recivido 
	    DatagramPacket packet = new DatagramPacket(buffer, 1024); 

	    System.out.println("Waiting for a a message ... ");

	    // El socket establce la conexión con el sender 
	    // Almacena el packet del sender en un packet 
	    // de recepción 
	    socket.receive(packet);
	    System.out.println("Messsaje from sender: ");

	    // decodificamos de bytes a string 
	    String msj = new String(packet.getData()).trim();

	    System.out.println("\n" + 
		    "message from: "+ packet.getAddress() + ": " + msj );

	}catch(Exception e){

	}
    }

}
