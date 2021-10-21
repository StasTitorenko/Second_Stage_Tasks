package javaThreads.optionalTask;

import java.util.concurrent.Semaphore;

public class Plane extends Thread {
    private final Semaphore runway;
    private final String tailNumber;

    public Plane(Semaphore runway, String tailNumber) {
        this.runway = runway;
        this.tailNumber = tailNumber;
    }

    @Override
    public void run() {
        try {
            runway.acquire();
            System.out.println("Plane " + tailNumber + " started entering the runway");
            System.out.println("Runway took over " + tailNumber);
            sleep(3000);
            System.out.println("Plane " + tailNumber + " took off");
            System.out.println("Runway is free");
            runway.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
