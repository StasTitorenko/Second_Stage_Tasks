package javaThreads.mainTask.parking;

import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private final Parking parking;
    private final String number;
    private final int waitingTime;

    public Car(Parking parking, String number) {
        this.parking = parking;
        this.number = number;
        this.waitingTime = (int) (Math.random() * 5);
    }

    public void run() {
        try {
            System.out.println("Car with number = " + number + " arrived to the parking");
            System.out.println("Car with number = " + number + " want's to park, and won't wait more than "
                    + waitingTime + " seconds");
            TimeUnit.SECONDS.sleep(waitingTime);
            if (parking.tryToParkCar(waitingTime)) {
                int parkTime = (int) (Math.random() * 20);
                System.out.println("Car with number = " + number + " parked to " + parkTime + " seconds");
                TimeUnit.SECONDS.sleep(parkTime);
                System.out.println("Car with number = " + number + " leave the parking");
                parking.leaveParking();
            } else {
                System.out.println("Car with number = " + number + " changed it's mind and leaves");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
