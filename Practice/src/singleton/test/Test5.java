package singleton.test;

import singleton.code.Singleton5;

import java.util.concurrent.*;

public class Test5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton5> callable = new Callable<Singleton5>() {
            @Override
            public Singleton5 call() throws Exception {
                return Singleton5.getInstance();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Singleton5> f1 = executorService.submit(callable);
        Future<Singleton5> f2 = executorService.submit(callable);

        Singleton5 s1 = f1.get();
        Singleton5 s2 = f2.get();

        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);

        executorService.shutdown();
    }
}
