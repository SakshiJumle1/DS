### AddInterface.java

import java.rmi.*;
public interface AddInterface extends Remote {
// Remote method
public int add(int x, int y) throws RemoteException;
}

### AddImplementation.java
import java.rmi.*;
import java.rmi.server.*;
public class AddImplementation extends UnicastRemoteObject implements AddInterface {
 // Constructor
public AddImplementation() throws RemoteException {
super();
}
// Implementation of remote method
@Override
public int add(int x, int y) throws RemoteException {
return (x + y);
}
}

###Server.java
import java.rmi.*;
public class Server {
public static void main(String[] args) {
try {
// Create remote object
AddInterface obj = new AddImplementation();
// Bind object with name
Naming.rebind("rmi://localhost/AddService", obj);
System.out.println("Server is ready.");
} catch (Exception e) {
System.out.println("Server failed: " + e);
}
}
}

###Client.java
import java.rmi.*;
public class Client {
public static void main(String[] args) {
try {
// Lookup remote object
AddInterface obj = (AddInterface) Naming.lookup("rmi://localhost/AddService");
// Call remote method
int result = obj.add(10, 20);
System.out.println("Addition Result: " + result);
} catch (Exception e) {
System.out.println("Client Error: " + e);
}
}
}


###RUNN##
TERMINAL 1
javac Server.java
javac Client.java
javac AddImplementation.java
javac AddImplementation.java
remiregistry

TERMINAL 2
java Server

TERMINAL 3
Java Client
