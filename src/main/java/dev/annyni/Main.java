package dev.annyni;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        CompletableFuture.runAsync(foo::first);

        CompletableFuture.runAsync(() -> {
            try {
                foo.second();
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture.runAsync(() -> {
            try {
                foo.third();
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(2000);
    }
}