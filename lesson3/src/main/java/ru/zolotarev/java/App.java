package ru.zolotarev.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args){
        try {
            readFile("temp/test1.txt");
            stitchFile("temp/test1.txt", "temp/test2.txt", "temp/test3.txt", "temp/test4.txt", "temp/test5.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void readFile(String nameFile)throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(nameFile));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int x;
        while ((x = in.read())!= -1) {
            out.write(x);
            System.out.print((char) x);
        }
        byte[] arr = out.toByteArray();
        System.out.println(" " + Arrays.toString(arr));
        in.close();
        out.close();
        System.out.println("---------------------------------");
    }

//    Есть ли смысл дробить потобные длинные строки или это ухудшает чтение кода? Пример:
//    private static  void stitchFile(String nameFile1,String nameFile2,
//                                    String nameFile3,String nameFile4,
//                                    String nameFile5) throws IOException{
    private static  void stitchFile(String nameFile1,String nameFile2, String nameFile3,String nameFile4, String unifiedFile) throws IOException{
        ArrayList<InputStream> al = new ArrayList<InputStream>();
        //можно ли процесс добавления сделать через цикл?
        al.add(new FileInputStream(nameFile1));
        al.add(new FileInputStream(nameFile2));
        al.add(new FileInputStream(nameFile3));
        al.add(new FileInputStream(nameFile4));
        al.add(new FileInputStream(unifiedFile));
        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(unifiedFile));
        int x;
        while ((x = in.read())!= -1) {
            out.write(x);
            System.out.print((char) x);
        }
        in.close();
        out.close();
    }
}
