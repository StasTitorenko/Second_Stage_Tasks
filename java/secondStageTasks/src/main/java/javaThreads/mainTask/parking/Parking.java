package javaThreads.mainTask.parking;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking extends Thread {
    Semaphore parkingPlace;

    public Parking(int numberOfPlaces) {
        this.parkingPlace = new Semaphore(numberOfPlaces, true);
    }

    public boolean tryToParkCar(int waitingTime) throws InterruptedException {
        return parkingPlace.tryAcquire(waitingTime, TimeUnit.SECONDS);
    }

    public void leaveParking() {
        parkingPlace.release();
    }

}

