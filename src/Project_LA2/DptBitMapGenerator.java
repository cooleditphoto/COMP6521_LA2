package Project_LA2;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class DptBitMapGenerator {

    public static void main(String[] args) throws IOException {
        String inputPath1 = Configuration.path1;
        String inputPath2 = Configuration.path2;
        String outputPath = Configuration.dptOutput;
        generate(inputPath1,(outputPath+"1.txt"));
        generate(inputPath2,(outputPath+"2.txt"));
    }

    /**
     * generate the bitmap file for the department number
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void generate(String inputPath,String outputPath) throws IOException {
        FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter =new FileWriter(outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        HashMap<Integer, HashSet<Integer>> map= new HashMap<>();

        int num = 0;
        String str = null;
        //store the data file information in the map
        while((str=bufferedReader.readLine())!=null){
            num++;
            Integer dpt = Integer.parseInt(str.substring(44,47));
            //System.out.println(dpt);
            if(!map.containsKey(dpt)){
                HashSet<Integer> set = new HashSet<>();
                set.add(num);
                map.put(dpt,set);
            }else{
                HashSet set = map.get(dpt);
                set.add(num);
                map.put(dpt,set);
            }
        }

        //output the bitmap index file
        for(int i=0;i<1000;i++){
            if(map.containsKey(i)){
                StringBuffer sb = new StringBuffer();
                HashSet resSet = map.get(i);
                for(int p=1;p<=num;p++){
                    if(resSet.contains(p)){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                }
                printWriter.println(sb.toString());
            }
        }

        printWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }
}
