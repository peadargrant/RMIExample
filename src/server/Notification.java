package server;

import java.rmi.*;

public interface Notification extends Remote 
{
    public String getSubject() throws RemoteException;
    public String getMessage() throws RemoteException;
}