package exercice1_semaphors.philosoph;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore table = new Semaphore(2);
        
        new Thread( new Philosophers("Platon", table)).start();
        new Thread( new Philosophers("Archimede", table)).start();
        new Thread( new Philosophers("Socrate", table)).start();

    }
}