import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImple extends UnicastRemoteObject implements Calculator
{
    public CalculatorImple() throws RemoteException
    {
        super();
    }

    public long add(long a, long b) throws RemoteException
    {
        return a+b;
    }

    public long subtrair(long a, long b) throws RemoteException{
        return a-b;
    }

    public long multiplicar(long a, long b) throws RemoteException{
        return a*b;
    }

    public long dividir(long a, long b) throws RemoteException{
        if(b==0){
            throw new RemoteException("Não é possível dividir por 0");
        }
        return a/b;
    }
}