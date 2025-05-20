
public class Server{
    public static void main(String[] args) {
    	
	try(com.zeroc.Ice.Communicator 
		communicator = 
		com.zeroc.Ice.Util.initialize(args)
		){

	    // RPC Runtime 
	    com.zeroc.Ice.ObjectAdapter adapter = 
		communicator
		.createObjectAdapterWithEndpoints("SimplePrinterAdapter", "default -p 10000");

	    // Server Stup 
	    com.zeroc.Ice.Object object = new AppI(); 

	    adapter.add(object, 
		    com.zeroc.Ice.Util
		    .stringToIdentity("SimplePrinter")); 

	    adapter.activate(); 
	    communicator.waitForShutdown(); 
	    
	}
    }
}
