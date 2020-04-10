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
        FileReader fr = new FileReader("/Users/wujiaqi/IdeaProjects/COMP6521_LA2/src/Data_Files/sample2.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("/Users/wujiaqi/comp6521/smallfile/sameple4.txt");
        PrintWriter pw = new PrintWriter(fw);
        String str;
        int num=0;
        while((str=br.readLine())!=null&&num<20000){
            pw.println(str);
            num++;
        }
        pw.close();
        fw.close();
        br.close();
        fr.close();
    }
}
