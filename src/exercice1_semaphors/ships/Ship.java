package exercice1_semaphors.ships;

public class Ship implements Runnable {

    @Override
    public void run() {
        try {

            Test.portPoint.acquire();
            System.out.println("Портовое место занял корабль " + Thread.currentThread().getName());
            Thread.sleep(2000);


            Test.worker.acquire();
            System.out.println("Рабочие приняли на обслуживание корабль " + Thread.currentThread().getName());
            Thread.sleep(5000);


            Test.worker.release();
            System.out.println("Рабочие разгрузили корабль " + Thread.currentThread().getName());
            Thread.sleep(1000);


            Test.portPoint.release();
            System.err.println("Корабль " + Thread.currentThread().getName() + " покинул порт");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
