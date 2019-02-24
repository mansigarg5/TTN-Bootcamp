import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Process implements Runnable{
    int id;

    public Process(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread name::"+Thread.currentThread().getName()+" Start :"+id);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread name::"+Thread.currentThread().getName()+" End :"+id);
    }
}

public class Ques9 {
    public static void main(String[] args) {

      //ExecutorService executorService= Executors.newFixedThreadPool(3);
        ExecutorService executorService= Executors.newCachedThreadPool();

        for (int i = 1; i <= 6; i++) {
            executorService.submit(new Process(i));
        }
        executorService.shutdown();
    }
}
