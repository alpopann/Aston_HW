public class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void startDeadlock() {
        Thread t1 = new Thread(this::task1, "T1");
        Thread t2 = new Thread(this::task2, "T2");
        t1.start();
        t2.start();
    }

    private void task1() {
        synchronized (lock1) {
            System.out.println("T1: захватил lock1");
            sleep(100);
            System.out.println("T1: ждет lock2");
            synchronized (lock2) {
                System.out.println("T1: захватил lock2");
            }
        }
    }

    private void task2() {
        synchronized (lock2) {
            System.out.println("T2: захватил lock2");
            sleep(100);
            System.out.println("T2: ждет lock1");
            synchronized (lock1) {
                System.out.println("T2: захватил lock1");
            }
        }
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
