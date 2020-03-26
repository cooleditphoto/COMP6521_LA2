package Util;

import java.io.*;

public class BitMapGenerator {

    public static void main(String[] args) throws IOException {
        String inputPath = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/test01.txt";
        String outputPath = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/bitmap.txt";
        generate(inputPath,outputPath,10000);
    }

    /**
     * generate bitmap file
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void generate(String inputPath,String outputPath,int dataNum) throws IOException {
        FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter =new FileWriter(outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        int[][] res = new int[1000][dataNum];
        for(int i=0;i<1000;i++){
            for(int j=0;j<dataNum;j++){
                res[i][j]=0;
            }
        }
        int p=0;
        String str = null;
        while((str=bufferedReader.readLine())!=null){
            Integer num = Integer.parseInt(str.substring(44,47));
            res[num][p]=1;
            p++;
        }
        for(int i=0;i<1000;i++){
            for(int j=0;j<dataNum;j++){
                printWriter.print(res[i][j]);
            }
            printWriter.println();
        }
        printWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }
}
