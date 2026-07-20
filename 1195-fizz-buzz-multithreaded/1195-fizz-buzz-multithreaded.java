import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int current = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz"
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (current <= n) {
            while (current <= n && !(current % 3 == 0 && current % 5 != 0)) {
                wait();
            }
            if (current <= n) {
                printFizz.run();
                current++;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz"
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (current <= n) {
            while (current <= n && !(current % 5 == 0 && current % 3 != 0)) {
                wait();
            }
            if (current <= n) {
                printBuzz.run();
                current++;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz"
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current <= n) {
            while (current <= n && current % 15 != 0) {
                wait();
            }
            if (current <= n) {
                printFizzBuzz.run();
                current++;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs x, where x is an integer
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            while (current <= n && (current % 3 == 0 || current % 5 == 0)) {
                wait();
            }
            if (current <= n) {
                printNumber.accept(current);
                current++;
                notifyAll();
            }
        }
    }
}