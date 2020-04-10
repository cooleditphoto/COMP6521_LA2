package Util;

import Project_LA2.Configuration;

import java.io.*;

public class CutFile {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(Configuration.path2);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("/Users/wujiaqi/comp6521/smallfile/sameple4.txt");
        PrintWriter pw = new PrintWriter(fw);
        String str;
        int num=0;
        while((str=br.readLine())!=null&&num<15000){
            pw.println(str);
            num++;
        }
        pw.close();
        fw.close();
        br.close();
        fr.close();
    }
}
