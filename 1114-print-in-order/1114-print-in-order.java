import java.util.concurrent.Semaphore;

class Foo {
    // Semaphores initialized with 0 permits
    private Semaphore run2;
    private Semaphore run3;

    public Foo() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // Print "first", then release 1 permit for run2
        printFirst.run();
        run2.release(); 
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until run2 gets a permit from first()
        run2.acquire(); 
        printSecond.run();
        // Release 1 permit for run3
        run3.release(); 
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until run3 gets a permit from second()
        run3.acquire(); 
        printThird.run();
    }
}