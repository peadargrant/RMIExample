package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NotificationImpl extends UnicastRemoteObject implements Notification {

    private final String subject;
    private final String message;
    
    public NotificationImpl(String subject, String message) throws RemoteException {
        super();
        this.subject = subject;
        this.message = message;
    }
    
    public String getSubject() throws RemoteException {
        return subject;
    }
    
    public String getMessage() throws RemoteException {
        return message;
    }
    
}
