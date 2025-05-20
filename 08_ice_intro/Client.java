public class Client {

    public static void main(String[] args) {
    	try(com.zeroc.Ice.Communicator communicator 
		= com.zeroc.Ice.Util.initialize(args)){

	    // RPC runtime 
	    com.zeroc.Ice.ObjectPrx base = 
		communicator
		.stringToProxy("SimplePrinter:default -p 10000");

	    // Stup 
	    Demo.PrinterPrx printer 
		= Demo.PrinterPrx.checkedCast(base); 

	    if(printer == null ){
		throw new Error(" Invalid Proxy");
	    }

	    // Solicitud de la operación 
	    printer.printString("Messaje desde el cliente");
		}
    }

}
