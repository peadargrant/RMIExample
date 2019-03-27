package server;

import java.rmi.*;

public interface HelloInterface extends Remote 
{
   public Notification sayHello(String name) throws RemoteException;

} //end interface
