package javaThreads.mainTask.port;

public class Runner {
    public static void main(String[] args) {
        Port port = new Port(3, 1500, 1300);
        new Ship(port, "Alpha", 500, 200).start();
        new Ship(port, "Beta", 500, 200).start();
        new Ship(port, "Gamma", 500, 200).start();
        new Ship(port, "Delta", 500, 200).start();
        new Ship(port, "Epsilon", 500, 200).start();
        new Ship(port, "Zeta", 500, 200).start();
        new Ship(port, "Eta", 500, 200).start();
        new Ship(port, "Theta", 500, 200).start();
        new Ship(port, "Iota", 500, 200).start();
        new Ship(port, "Kappa", 500, 200).start();
    }
}
