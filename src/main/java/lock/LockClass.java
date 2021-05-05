package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass {
    Lock lock = new ReentrantLock();

    public void print() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " first method.");
    }

    public void print2() {

        System.out.println(Thread.currentThread().getName() + " second method.");
    }

    public void print3() {
        System.out.println(Thread.currentThread().getName() + " third method.");
        lock.unlock();
    }

}
