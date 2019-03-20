package server;

// Server code - this code is responsible for creating the remote object
// and making it available on the registry for use.
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {

    public static void main(String args[]) throws Exception {
        if (args.length < 1) {
            throw new Exception("args must be [port]");
        }
        int RMIPortNum = Integer.parseInt(args[0].trim());

        // Turn on the registry to allow storage of remote objects
        startRegistry(RMIPortNum);

        // Create the object to be used remotely
        HelloImpl exportedObj = new HelloImpl();
        // Create a location and label for the object to be stored at
        String registryURL = "rmi://localhost:" + RMIPortNum + "/hello";
        // "Bind" / "Export" the remote object (make it available in the registry)
        Naming.rebind(registryURL, exportedObj);

        System.out.println("Server registered.  Registry currently contains:");
        // list names of objects currently in the registry
        listRegistry(registryURL);

        System.out.println("Hello Server ready.");
    }

    // This method starts a RMI registry on the local host, if it
    // does not already exists at the specified port number.
    private static void startRegistry(int RMIPortNum) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);
            registry.list();  // This call will throw an exception
            // if the registry does not already exist
        } catch (RemoteException e) {
            // No valid registry at that port.
            System.out.println("RMI registry cannot be located at port " + RMIPortNum);
            Registry registry = LocateRegistry.createRegistry(RMIPortNum);
            System.out.println("RMI registry created at port " + RMIPortNum);
        }
    } // end startRegistry

    // This method lists the names registered with a Registry object
    private static void listRegistry(String registryURL) throws RemoteException, MalformedURLException {
        System.out.println("Registry " + registryURL + " contains: ");
        String[] names = Naming.list(registryURL);
        for (String name : names) {
            System.out.println(name);
        }
    } //end listRegistry

} // end class
