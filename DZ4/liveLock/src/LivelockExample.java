import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void startLivelock() {
        Thread t1 = new Thread(() -> attemptLocks(lock1, lock2), "T1");
        Thread t2 = new Thread(() -> attemptLocks(lock2, lock1), "T2");
        t1.start();
        t2.start();
    }

    private void attemptLocks(ReentrantLock first, ReentrantLock second) {
        while (true) {
            if (first.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": locked " + first);
                    sleep(50);
                    if (second.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + ": locked " + second);
                            System.out.println(Thread.currentThread().getName() + ": сделал работу и вышел");
                            return;
                        } finally {
                            second.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() +
                                ": не смог захватить " + second + " — освобождаю " + first);
                    }
                } finally {
                    first.unlock();
                }
            }
            sleep(50);
        }
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
