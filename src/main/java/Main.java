import lock.LockClass;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    static LockClass lockClass = new LockClass();

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                Thread customThread = new Thread(() -> {
                    atomicInteger.incrementAndGet();
                });
                customThread.start();
            }
        });

        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                Thread customThread = new Thread(() -> {
                    atomicInteger.incrementAndGet();
                });
                customThread.start();
            }
        });
        firstThread.start();
        secondThread.start();

        for (; ;) {
            if (!firstThread.isAlive() && !secondThread.isAlive()) {
                System.out.println(atomicInteger);
                break;
            }
        }

        Thread firstLockThread = new Thread(() -> {
            lockClass.print();
            lockClass.print2();
            lockClass.print3();
        });

        Thread secondLockThread = new Thread(() -> {
            lockClass.print();
            lockClass.print2();
            lockClass.print3();
        });

        Thread thirdLockThread = new Thread(() -> {
            lockClass.print();
            lockClass.print2();
            lockClass.print3();
        });

        firstLockThread.start();
        secondLockThread.start();
        thirdLockThread.start();

    }
}
