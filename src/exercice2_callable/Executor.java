package exercice2_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Executor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable <String> callable1 = () -> {
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        };

        List<Future <String>> futures = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            futures.add(executorService.submit(callable1));
        }

        for (Future f: futures) {
            System.out.println("f.get() = " + f.get());
        }

        executorService.shutdown();

    }
}
