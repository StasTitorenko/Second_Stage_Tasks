package javaThreads.optionalTask;

import java.util.concurrent.Semaphore;

public class Airport {
    public static void main(String[] args) {
        Semaphore airportLines = new Semaphore(5, true);
        for (int i = 0; i < 10; i++) {
            new Plane(airportLines, String.valueOf(i)).start();
        }
    }
}
