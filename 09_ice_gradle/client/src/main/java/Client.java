import com.zeroc.Ice.*;

import Demo.*; 

public class Client {
    public static void main(String[] args) {
    	try(Communicator communicator 
		= Util.initialize(args, 
		    "properties.cfg")) {

	    Suscriber suscriber = new SuscriberI(); 

	    ObjectAdapter adapter = 
		communicator
		.createObjectAdapter("Suscriber"); 

	    ObjectPrx proxys = adapter
		.add(suscriber, 
			Util.stringToIdentity("NN"));

	    adapter.activate(); 

	    SuscriberPrx suscriberPrx = 
		SuscriberPrx.checkedCast(proxys);

	    PublisherPrx publisher = 
		PublisherPrx.checkedCast(
			communicator
			.propertyToProxy(
			    "publisher.proxy")); 

	    if(publisher == null){
		throw new Error("Bat Ice Proxy"); 
	    }
    		
    	} 
    }
}
