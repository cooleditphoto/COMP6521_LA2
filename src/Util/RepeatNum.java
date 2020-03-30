package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class RepeatNum {

    public static void main(String[] args) throws IOException {
        int num = 0;
        String path = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/sample1.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String path2 = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/sample2.txt";
        FileReader fileReader2 = new FileReader(path2);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        HashSet<String> set =new HashSet<>();
        String str;
        while((str=bufferedReader.readLine())!=null){
            set.add(str.substring(0,8));
        }
        /*while((str=bufferedReader2.readLine())!=null){
            set.add(str.substring(0,8));
            num++;
        }*/
        System.out.println(num);
        System.out.println(set.size());
        bufferedReader2.close();
        fileReader2.close();
        bufferedReader.close();
        fileReader.close();
    }
}
