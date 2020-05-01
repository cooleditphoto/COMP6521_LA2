package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class RepeatNum {

    /**
     * repeat file number main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int num = 0;
        String path = "";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String path2 = "";
        FileReader fileReader2 = new FileReader(path2);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        HashSet<String> set =new HashSet<>();
        String str;
        while((str=bufferedReader.readLine())!=null){
            set.add(str.substring(0,8));
        }
        while((str=bufferedReader2.readLine())!=null){
            set.add(str.substring(0,8));
            num++;
        }
        System.out.println(num);
        System.out.println(set.size());
        bufferedReader2.close();
        fileReader2.close();
        bufferedReader.close();
        fileReader.close();
    }
}
