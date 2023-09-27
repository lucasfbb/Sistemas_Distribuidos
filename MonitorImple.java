import java.util.LinkedList;

class MonitorPC {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacidade = 10;

    public synchronized void produz(int item) throws InterruptedException {
        while (buffer.size() == capacidade) {
            wait(); // Aguarda se o buffer estiver cheio
        }

        buffer.add(item);
        System.out.println("Produtor produziu: " + item);
        notifyAll(); // Notifica os consumidores
    }

    public synchronized int consome() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // Aguarda se o buffer estiver vazio
        }

        int item = buffer.remove();
        System.out.println("Consumidor consumiu: " + item);
        notifyAll(); // Notifica os produtores
        return item;
    }
}

class Produtor extends Thread {
    private MonitorPC monitor;

    public Produtor(MonitorPC monitor) {
        this.monitor = monitor;
    }

    public void run() {
        try {
            while (true) {
                int item = (int) (Math.random() * 100);
                monitor.produz(item);
                Thread.sleep(100); // Simula a produção
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumidor extends Thread {
    private MonitorPC monitor;

    public Consumidor(MonitorPC monitor) {
        this.monitor = monitor;
    }

    public void run() {
        try {
            while (true) {
                int item = monitor.consome();
                Thread.sleep(200); // Simula o consumo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class MonitorImple {
    public static void main(String[] args) {
        MonitorPC monitor = new MonitorPC();
        Produtor produtor = new Produtor(monitor);
        Consumidor consumidor = new Consumidor(monitor);

        produtor.start();
        consumidor.start();
    }
}
