package dev.annyni;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        Thread first = new Thread(() -> {
            foo.first();
        });

        Thread second = new Thread(() -> {
            try {
                first.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            foo.second();
        });

        Thread third = new Thread(() -> {
            try {
                second.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            foo.third();
        });

        third.start();
        second.start();
        first.start();
        first.join();
        second.join();
        third.join();
    }
}