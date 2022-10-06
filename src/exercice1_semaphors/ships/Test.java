package exercice1_semaphors.ships;

import java.util.concurrent.Semaphore;

public class Test {

    static Semaphore portPoint = new Semaphore(5);
    static Semaphore worker = new Semaphore(3);

    public static void main(String[] args) {


        for (int i = 1; i < 11; i++) {
            new Thread( new Ship(), "Баржа № " + i).start();
        }


    }
}
