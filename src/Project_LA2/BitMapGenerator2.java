package Project_LA2;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class BitMapGenerator2 {

    public static void main(String[] args) throws IOException {
        String inputPath = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/test01.txt";
        String outputPath = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/bitmap.txt";
        generate(inputPath,outputPath, DataGenerator.num);
    }

    public static void generate(String inputPath,String outputPath,int dataNum) throws IOException {
        FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter =new FileWriter(outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        HashMap<String, HashSet<Integer>> map= new HashMap<>();

        int num = 0;
        String str = null;
        //store the data file information in the map
        while((str=bufferedReader.readLine())!=null){
            num++;
            String dpt = str.substring(44,47);
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
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                for(int t=0;t<10;t++){
                    String opt = ""+i+j+t;
                    if(map.containsKey(opt)){
                        StringBuffer sb = new StringBuffer();
                        HashSet resSet = map.get(opt);
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
            }
        }


        printWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }
}
