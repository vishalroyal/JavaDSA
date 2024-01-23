package MultiThreading;

import javax.sql.rowset.CachedRowSet;
import java.util.concurrent.Callable;

public class RunnableThread implements  Runnable, Callable<String> {
/*
    @Override
    public void run() {
        System.out.println("Ye Runnable ka hain bhai ");
    }


 */
    @Override
    public String call() throws Exception {
       return "Ye Callable ka hain bhai";

    }


    @Override
    public void run() {

    }
}
