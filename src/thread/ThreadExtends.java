package thread;

public class ThreadExtends extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadExtends --------- " + Thread.currentThread().getName() + "=============" + i);
        }
    }
}
