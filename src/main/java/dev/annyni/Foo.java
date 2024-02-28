package dev.annyni;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Foo {

    private final CyclicBarrier cyclicBarrier;

    public Foo() {
        this.cyclicBarrier = new CyclicBarrier(2);
    }

    public void first() {
        System.out.print("first");
    }

    public void second() throws BrokenBarrierException, InterruptedException {
        System.out.print("second");
        cyclicBarrier.await();
    }

    public void third() throws BrokenBarrierException, InterruptedException {
        cyclicBarrier.await();
        System.out.print("third");

    }
}
