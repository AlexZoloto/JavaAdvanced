package ru.zolotarev.entity;

public class WritingThreeLetters implements Runnable {
    private static char c = 'A';
    private final static Object mon = new Object();

    private char currentLetter;
    private char nextLetter;

    public WritingThreeLetters(char currentLetter, char nextLetter) {
        this.currentLetter = currentLetter;
        this.nextLetter = nextLetter;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (mon) {
                try {
                    while (c != currentLetter)
                        mon.wait();
                    System.out.print(currentLetter);
                    c = nextLetter;
                    mon.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}