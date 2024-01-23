package MultiThreading;

import java.util.concurrent.*;

public class Multithread extends Thread {

    @Override
    public void run() {
      System.out.println("Ye Thread ka hain bhai");
    }

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        Multithread multithread=new Multithread();
        Multithread multithread1=new Multithread();
        Multithread multithread2=new Multithread();

        //using executors service starts from here--->

        //to create single thread execution
        ExecutorService executor= Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hey executor");
            }
        });
        executor.shutdown();

        // to create fixed thread
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        Future future= executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("fix thread pool");
            };
        });

        future.get();
        executorService.shutdown();


        //using schedulepool
        ExecutorService executorService3=Executors.newScheduledThreadPool(  1);
        executorService3.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("fix thread pool");
            };
        });
        executorService3.shutdown();

        ExecutorService executor4= Executors.newSingleThreadExecutor();
        //Using CallableInterface
       Future future1=executor4.submit(new Callable<String>() {
           @Override
           public String call() throws Exception {
               return "Ye callable ka hain bhai";
           }
       });
        future1.get();
       RunnableThread runnableThread=new RunnableThread();
      FutureTask<String> futureTask=new FutureTask<>(runnableThread);
      Thread thread=new Thread(futureTask);
      thread.start();



        //---------------------- using executors service stops here----<>
        multithread.start();
        multithread.sleep(10000);
        multithread1.start();
        multithread2.start();

        /*
        RunnableThread runnableThread=new RunnableThread();
        Thread thread=new Thread(runnableThread);
        thread.start();

         */



        System.out.println("Thread name " + multithread.getName());
        System.out.println("Thread status " + multithread.isAlive());
        System.out.println("Thread state "+ multithread.getState());
        System.out.println();
/*
        System.out.println("Thread name " + );
        System.out.println("Thread status " + multithread1.isAlive());
        System.out.println("Thread state "+ multithread1.getState());

/*
        System.out.println("Thread name " + multithread2.getName());
        System.out.println("Thread status " + multithread2.isAlive());
        System.out.println("Thread state "+ multithread2.getState());
/*
        System.out.println("Thread name " + thread.getName());
        System.out.println("Thread status " + thread.isAlive());
        System.out.println("Thread state "+ thread.getState());

 */

    }


}
