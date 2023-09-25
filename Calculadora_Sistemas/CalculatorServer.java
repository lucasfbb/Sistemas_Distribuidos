import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer
{
    CalculatorServer()
    {
        try
        {
            Calculator calculadora = new CalculatorImple();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/Calculadora", calculadora);
            System.out.println("Servidor da calculadora pronto!!");
        }
        catch (Exception e)
        {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new CalculatorServer();
    }
}