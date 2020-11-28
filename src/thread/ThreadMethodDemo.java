package thread;

public class ThreadMethodDemo {
    public static void main(String[] args) {
        // 强行插入某一个线程
//        methodJoin();
        // 礼让一次
        methodYield();
    }

    private static void methodYield() {
        // 开启一个线程 - 线程1
        ThreadExtends threadExtends = new ThreadExtends();
        threadExtends.start();

        // 在主线程继续运行
        for (int i = 0; i < 10; i++){
            if (i == 3){
                Thread.yield();
                System.out.println("Main 礼让一次 --------- " + Thread.currentThread().getName() + " ========= " + i);
            } else {
                System.out.println("Main --------- " + Thread.currentThread().getName() + " ========= " + i);
            }
        }
    }

    private static void methodJoin() {
        // 开启一个线程 - 线程1
        ThreadExtends threadExtends = new ThreadExtends();
        threadExtends.start();

        // 在主线程继续运行
        for (int i = 0; i < 10; i++){
            System.out.println("Main --------- " + Thread.currentThread().getName() + " ========= " + i);
            if (i == 3){
                // 当这里执行到3的时候，让另一个线程（线程1）去执行直到另一个程序执行完毕
                try {
                    threadExtends.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
