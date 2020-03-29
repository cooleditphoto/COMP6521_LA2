package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class FindRecordTest {

    public static void main(String[] args) throws IOException {
        String path = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/test01.txt";
        RandomAccessFile file = new RandomAccessFile(path, "rw");
        ArrayList<Integer> list  = new ArrayList<>();
        for(int i=0;i<1000;i++){
            list.add(i);
        }
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        long time  = new Date().getTime();
        String str;
        while((str=bufferedReader.readLine())!=null){
           //System.out.println(str);
        }
        long time2 = new Date().getTime();
        System.out.println(time2-time);
        bufferedReader.close();
        fileReader.close();

        Collections.shuffle(list);


        FileReader fileReader2 = new FileReader(path);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader);

        long time3  = new Date().getTime();
        /*while((bufferedReader2.readLine())!=null){
            num2++;
        }*/
        for(int i=0;i<1000;i++){
            findRecordFromFile(file,list.get(i));
        }
        long time4 = new Date().getTime();
        System.out.println(time4-time3);
        bufferedReader2.close();
        fileReader2.close();


        file.close();

        System.out.println("result: "+((time4-time3)-(time2-time)));



    }


    public static String findRecordFromFile( RandomAccessFile file, int lineNum) throws IOException {

        long position = (lineNum-1) * 100;
        file.seek(position);
        byte[] bytes = new byte[100];
        file.read(bytes);
        String string = new String(bytes, StandardCharsets.UTF_8);
        //System.out.println(string);
        return string;
    }
}
