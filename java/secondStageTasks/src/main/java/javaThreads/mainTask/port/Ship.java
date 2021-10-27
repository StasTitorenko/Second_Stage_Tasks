package javaThreads.mainTask.port;

import java.util.concurrent.TimeUnit;

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

    synchronized void unloadContainersFromShipToDock(String message, int timeSpentAtDock) {
        try {
            int maxLoadToPort = port.getMaxNumberOfContainers() - port.getCurrentNumberOfContainers();
            System.out.println(message + " will be unloaded");
            TimeUnit.MILLISECONDS.sleep(timeSpentAtDock);
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void loadContainersToShipFromDock(String message, int timeSpentAtDock) {
        try {
            int maxLoadToShip = maxContainerCarryingCapacity - currentNumberOfTransportedContainers;
            System.out.println(message + " will be loaded");
            TimeUnit.MILLISECONDS.sleep(timeSpentAtDock);
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void run() {
        final String message = "Ship named " + name;
        int randomChoiceOfAction = (int) (1 + Math.random() * 2);
        int timeSpentAtDock = (int) (1000 + Math.random() * 10000);
        System.out.println(message + " arrived to the port");
        port.moorToDock();
        System.out.println(message + " is docking");
        if (randomChoiceOfAction == 1) {
            unloadContainersFromShipToDock(message, timeSpentAtDock);
        } else {
            loadContainersToShipFromDock(message, timeSpentAtDock);
        }
        port.leaveDock();
        System.out.println(message + " leave dock");
    }
}
