package javaThreads.mainTask.port;

public class Ship extends Thread {
    private final Port port;
    private final String name;
    private final int maxContainerCarryingCapacity;
    private int currentNumberOfTransportedContainers;

    public Ship(Port port, String name, int maxContainerCarryingCapacity, int currentNumberOfTransportedContainers) {
        this.port = port;
        this.name = name;
        this.maxContainerCarryingCapacity = maxContainerCarryingCapacity;
        this.currentNumberOfTransportedContainers = currentNumberOfTransportedContainers;
    }

    synchronized void unloadContainersFromShipToDock(String message) {
        int maxLoadToPort = port.getMaxNumberOfContainers() - port.getCurrentNumberOfContainers();
        System.out.println(message + " will be unloaded");
        if (maxLoadToPort > currentNumberOfTransportedContainers) {
            port.setCurrentNumberOfContainers(port.getCurrentNumberOfContainers() + currentNumberOfTransportedContainers);
            System.out.println(message + " unloaded " + currentNumberOfTransportedContainers + " containers");
            currentNumberOfTransportedContainers = 0;
        } else {
            if (port.getCurrentNumberOfContainers() == port.getMaxNumberOfContainers()) {
                System.out.println("The port is full of containers " + message + " will not be able to unload");
            } else {
                port.setCurrentNumberOfContainers(port.getCurrentNumberOfContainers() + maxLoadToPort);
                currentNumberOfTransportedContainers = currentNumberOfTransportedContainers - maxLoadToPort;
                System.out.println(message + " unloaded " + currentNumberOfTransportedContainers + " containers");
            }
        }
    }

    synchronized void loadContainersToShipFromDock(String message) {
        int maxLoadToShip = maxContainerCarryingCapacity - currentNumberOfTransportedContainers;
        System.out.println(message + " will be loaded");
        if (port.getCurrentNumberOfContainers() > maxLoadToShip) {
            port.setCurrentNumberOfContainers(port.getCurrentNumberOfContainers() - maxLoadToShip);
            currentNumberOfTransportedContainers = currentNumberOfTransportedContainers + maxLoadToShip;
            System.out.println(message + " loaded " + maxLoadToShip + " containers");
        } else {
            if (port.getCurrentNumberOfContainers() == 0) {
                System.out.println("The port is empty " + message + " will not be able to load");
            } else {
                currentNumberOfTransportedContainers = currentNumberOfTransportedContainers + port.getCurrentNumberOfContainers();
                System.out.println(message + " loaded " + port.getCurrentNumberOfContainers() + " containers");
                port.setCurrentNumberOfContainers(0);
            }
        }
    }

    synchronized public void run() {
        final String message = "Ship named " + name;
        System.out.println(message + " arrived to the port");
        port.goToDock();
        System.out.println(message + " is docking");
        unloadContainersFromShipToDock(message);
        loadContainersToShipFromDock(message);
        port.leaveDock();
        System.out.println(message + " leave dock");

    }
}
