import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        // Philosopher 4 picks right fork first to avoid deadlock
        if (philosopher == 4) {
            forks[right].lock();
            forks[left].lock();
        } else {
            forks[left].lock();
            forks[right].lock();
        }

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putRightFork.run();
        putLeftFork.run();

        forks[right].unlock();
        forks[left].unlock();
    }
}