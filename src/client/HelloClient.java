package client;

import java.rmi.Naming;

public class HelloClient {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            throw new Exception("args must be [registry hostname, port]");
        }
        String hostName = args[0];
        int RMIPort = Integer.parseInt(args[1]);

        // RMI connection code - link client to remote object
        String registryURL = "rmi://" + hostName + ":" + RMIPort + "/hello";
        // find the remote object and cast it to an interface object
        server.HelloInterface h = (server.HelloInterface) Naming.lookup(registryURL);
        System.out.println("Lookup completed ");

        System.out.println("Now connected to: " + h);

        // invoke the remote method
        String message = h.sayHello("Donald Duck");
        System.out.println("HelloClient: " + message);
    }
}
