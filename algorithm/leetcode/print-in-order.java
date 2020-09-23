class Foo {
    private Object lock;
    volatile int order = 1;
    
    public Foo() {
        this.lock = new Object();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        synchronized (lock){
            while (order != 1) lock.wait();
            printFirst.run();
            order = 2;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while (order != 2) lock.wait();
            printSecond.run();
            order = 3;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while (order != 3) lock.wait();
            printThird.run();
            order = 1;
            lock.notifyAll();
        }
    }
}
