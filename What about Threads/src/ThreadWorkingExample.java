public class ThreadWorkingExample extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void example(int numOfThreads){
        for (int i = 0; i < numOfThreads; i ++) {
            Thread thread = new ThreadWorkingExample();
            thread.start();
        }
    }
}
