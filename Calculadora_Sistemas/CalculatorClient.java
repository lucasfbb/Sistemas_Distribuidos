import java.rmi.*;
public class CalculatorClient
{
    public static void main(String[] args)
    {
        try
        {
            Calculator calculadora = (Calculator) Naming.lookup("rmi://localhost/Calculadora");
            System.out.println("Adição : "+calculadora.add(20, 15));
            System.out.println("Subtração: "+calculadora.subtrair(20,15));
            System.out.println("Multiplicação: "+calculadora.multiplicar(20,15));
            System.out.println("Divisão: "+calculadora.dividir(20,15));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}