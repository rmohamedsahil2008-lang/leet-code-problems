 class Foo {
    private final CountDownLatch latch1;
    private final CountDownLatch latch2;

    public Foo() {
        // Initialize latches with a count of 1
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        // Release the lock for the second thread
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until latch1 is counted down to 0 (after first() executes)
        latch1.await();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        // Release the lock for the third thread
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until latch2 is counted down to 0 (after second() executes)
        latch2.await();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
