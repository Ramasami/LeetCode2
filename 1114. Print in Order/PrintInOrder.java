class PrintInOrder {

    int a[];

    public Foo() {
        a = new int[]{0,0};
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        a[0] = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (a[0] == 0)
            Thread.sleep(1);
        printSecond.run();
        a[1] = 1;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (a[1] == 0)
            Thread.sleep(1);
        printThird.run();
    }
}