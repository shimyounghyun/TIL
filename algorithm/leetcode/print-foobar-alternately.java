class FooBar {
    private int n;
    private Object lock;
    volatile boolean flag = true;
    
    public FooBar(int n) {
        this.n = n;
        this.lock = new Object();
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock){
                if (!flag) lock.wait();
                printFoo.run();
                flag = false;
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock){
                if (flag) lock.wait();
                printBar.run();
                flag = true;
                lock.notify();
            }
        }
    }
}
