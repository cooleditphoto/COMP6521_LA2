package Project_LA2;

import java.io.*;
import java.util.HashSet;

public class SexBitMapGenerator {

    public static void main(String[] args) throws IOException {
        String inputPath = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/test01.txt";
        String outputPath = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/bitmap.txt";
        generate(inputPath,outputPath, 10000);
    }

    public static void generate(String inputPath,String outputPath,int dataNum) throws IOException {
        FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter =new FileWriter(outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        //store all line number with 0
        HashSet<Integer> set = new HashSet<>();
        String str = null;
        int num = 0;
        while((str=bufferedReader.readLine())!=null){
            num++;
            if(str.substring(43,44).equals("0")){
                set.add(num);
            }
        }

        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(int i=1;i<=num;i++){
            if(set.contains(i)){
                sb.append(1);
                sb2.append(0);
            }else{
                sb.append(0);
                sb2.append(1);
            }
        }
        printWriter.println(sb.toString());
        printWriter.println(sb2.toString());

        printWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }
}
