package ru.zolotarev;

import ru.zolotarev.entity.WriteData;
import ru.zolotarev.entity.WritingThreeLetters;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Application {
    public static void main(String[] args) {
        //task1
        new Thread(new WritingThreeLetters('A', 'B')).start();
        new Thread(new WritingThreeLetters('C', 'A')).start();
        new Thread(new WritingThreeLetters('B', 'C')).start();

        //task2
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("resourses/random.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Neyt");;
        }
        Thread t1 = new Thread(new WriteData(pw, 4));
        Thread t2 = new Thread(new WriteData(pw, 7));
        Thread t3 = new Thread(new WriteData(pw, 15));
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        pw.close();
    }
}
