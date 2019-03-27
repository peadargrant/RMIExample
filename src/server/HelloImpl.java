package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface 
{
    public HelloImpl() throws RemoteException 
    {
            super( );
    }

    @Override
    public NotificationImpl sayHello(String name) throws RemoteException 
    {
            System.out.println("method called");
            return new NotificationImpl("Hello name", "Welcome " + name + " to the machine.");
    }
} // end class
