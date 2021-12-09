package team.hedonism.resourceHierarchy;

import team.hedonism.BaseFork;
import team.hedonism.BasePhilosopher;

public class Philosopher extends BasePhilosopher implements Runnable {

    protected Philosopher(BaseFork leftFork, BaseFork rightFork) {
        super(leftFork, rightFork);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                think();
                synchronized (leftFork) {
                    leftFork.take();
                    synchronized (rightFork) {
                        rightFork.take();
                        eat();
                        rightFork.put();
                        leftFork.put();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted");
        }
    }
}
