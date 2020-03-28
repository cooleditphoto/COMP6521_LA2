package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class getLineNum {

    public static void main(String[] args) throws IOException {
        String path = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/bitmap.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int num=0;
        while(bufferedReader.readLine()!=null){
            num++;
        }
        System.out.println(num);
        bufferedReader.close();
        fileReader.close();
    }
}
