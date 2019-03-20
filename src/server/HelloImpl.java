package server;

import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface 
{
    public HelloImpl() throws RemoteException 
    {
            super( );
    }

    @Override
    public String sayHello(String name) throws RemoteException 
    {
            System.out.println("method called");
            return "Hello, World! " + name;
    }
} // end class
