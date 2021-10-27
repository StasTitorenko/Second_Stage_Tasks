package javaThreads.mainTask.port;

import java.util.concurrent.Semaphore;

public class Port extends Thread {
    private final int maxNumberOfContainers;
    private int currentNumberOfContainers;
    Semaphore docks;

    Port(int numberOfDocks, int maxNumberOfContainers, int currentNumberOfContainers) {
        this.maxNumberOfContainers = maxNumberOfContainers;
        this.currentNumberOfContainers = currentNumberOfContainers;
        this.docks = new Semaphore(numberOfDocks, true);
    }

    int getMaxNumberOfContainers() {
        return maxNumberOfContainers;
    }

    int getCurrentNumberOfContainers() {
        return currentNumberOfContainers;
    }

    void setCurrentNumberOfContainers(int currentNumberOfContainers) {
        this.currentNumberOfContainers = currentNumberOfContainers;
    }

    void moorToDock() {
        try {
            docks.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void leaveDock() {
        docks.release();
    }
}
