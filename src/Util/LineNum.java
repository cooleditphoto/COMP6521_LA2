package Util;

import java.io.*;

public class LineNum {

    public static void main(String[] args) throws IOException {
        String path = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/src/Data_Files/phase2_output.txt";
        System.out.println(getLineNum(path));
    }

    public static int getLineNum(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //FileWriter fileWriter = new FileWriter("/Users/wujiaqi/IdeaProjects/COMP6521_LA2/p2.txt");
        //PrintWriter printWriter = new PrintWriter(fileWriter);
        int i=7;
        int num=0;
        String str;
        String str2 = "";
        while((str=bufferedReader.readLine())!=null){
            num++;
            if(str.compareTo(str2)<0&&i<9) {
                System.out.println("str:"+str);
                System.out.println("str2:"+str2);
                System.out.println("num:"+num);
                i++;
            }
            str2=str;
        }
        //printWriter.close();
        //fileWriter.close();
        bufferedReader.close();
        fileReader.close();
        return num;
    }
}
