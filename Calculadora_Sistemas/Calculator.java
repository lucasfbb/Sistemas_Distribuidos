import java.rmi.*;

public interface Calculator extends Remote
{
    public long add(long a, long b) throws RemoteException;
    public long subtrair(long a, long b) throws RemoteException;
    public long multiplicar(long a, long b) throws RemoteException;
    public long dividir(long a, long b) throws RemoteException;
}