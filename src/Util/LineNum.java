package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LineNum {

    public static void main(String[] args) throws IOException {
        String path = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/bitmap.txt";
        System.out.println(getLineNum(path));
    }

    public static int getLineNum(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int num=0;
        while(bufferedReader.readLine()!=null){
            num++;
        }
        bufferedReader.close();
        fileReader.close();
        return num;
    }
}
