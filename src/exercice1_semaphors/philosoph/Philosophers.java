package exercice1_semaphors.philosoph;

import java.util.concurrent.Semaphore;

public class Philosophers implements Runnable {

    String name;
    Semaphore semaphore;
    boolean isHungry = true;

    public Philosophers(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {

            semaphore.acquire();
            System.out.println("Философ " + name + " сел за стол !");

            Thread.sleep(2000);

            System.out.println("Философ " + name + " поел, и покинул стол !");
            semaphore.release();
            Thread.sleep(2000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
