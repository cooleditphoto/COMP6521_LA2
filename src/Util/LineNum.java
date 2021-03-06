package Util;

import Project_LA2.Configuration;

import java.io.*;

public class LineNum {

    /**
     * main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //String path = Configuration.idOutput;
        String path = Configuration.demoOutput;
        System.out.println(getLineNum(path));
    }

    /**
     * calculate the line number of the file
     * @param path
     * @return
     * @throws IOException
     */
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
        }
        //printWriter.close();
        //fileWriter.close();
        bufferedReader.close();
        fileReader.close();
        return num;
    }
}
