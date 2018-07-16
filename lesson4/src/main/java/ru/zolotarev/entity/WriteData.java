package ru.zolotarev.entity;

import java.io.PrintWriter;

public class WriteData implements Runnable {
    private int x;
    private PrintWriter pw = null;
    private int y = 10;

    public WriteData(PrintWriter pw, int x) {
        this.pw = pw;
        this.x = x;
    }

    public void run() {
        for (int i = 0; i < y; i++) {
            try {
                Thread.sleep(20);
                pw.print(x);
                pw.flush();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}