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
        cutFile(Configuration.originalPath2,
                Configuration.path2,
                100000,15000);
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
        while(num1<skipNum&&br.readLine()!=null){
            num1++;
        }
        String str;
        int num2 = 0;
        while(num2<cutNum&&(str=br.readLine())!=null){
            pw.println(str);
            num2++;
        }
        pw.close();
        fw.close();
        br.close();
        fr.close();
    }
}
