package javaThreads.mainTask.parking;


import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        Parking parking = new Parking(5);
        for (int i = 0; i < 10; i++) {
            new Car(parking, String.valueOf(i)).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
