import java.util.concurrent.locks.*;

public class AlternatingPrint {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition cond1 = lock.newCondition();
    private final Condition cond2 = lock.newCondition();
    private boolean oneTurn = true;

    public void start() {
        Thread t1 = new Thread(this::printOne);
        Thread t2 = new Thread(this::printTwo);
        t1.start();
        t2.start();
    }

    private void printOne() {
        while (true) {
            lock.lock();
            try {
                while (!oneTurn) cond1.await();
                System.out.print("1");
                oneTurn = false;
                cond2.signal();
            } catch (InterruptedException e) {
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    private void printTwo() {
        while (true) {
            lock.lock();
            try {
                while (oneTurn) cond2.await();
                System.out.print("2");
                oneTurn = true;
                cond1.signal();
            } catch (InterruptedException e) {
                break;
            } finally {
                lock.unlock();
            }
        }
    }
}
