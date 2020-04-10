package Util;

import Project_LA2.Configuration;

import java.io.*;

public class CutFile {

    /**
     * cut the front lines and output it to another file
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        cutFile("/Users/wujiaqi/IdeaProjects/COMP6521_LA2/src/Data_Files/sample1.txt",
                "/Users/wujiaqi/comp6521/smallfile/sameple3.txt",
                20000,20000);
    }

    /**
     * cut file
     * @param inputPath
     * @param outputPath
     * @param skipNum
     * @param cutNum
     */
    public static void cutFile(String inputPath,String outputPath,int skipNum,int cutNum) throws IOException {
        FileReader fr = new FileReader(inputPath);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(outputPath);
        PrintWriter pw = new PrintWriter(fw);

        int num1=0;
        while(br.readLine()!=null&&num1<skipNum){
            num1++;
        }
        String str;
        int num2 = 0;
        while((str=br.readLine())!=null&&num2<cutNum){
            pw.println(str);
            num2++;
        }
        pw.close();
        fw.close();
        br.close();
        fr.close();
    }
}
