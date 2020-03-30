package Project_LA2;

import Project_LA2.DataGenerator;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class IDBitMapGeneratorLimitMemory {

    public static void main(String[] args) throws IOException {
        int lineNum = 10000;
        long time1 = new Date().getTime();
        String inputPath = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/sample1.txt";
        String outputPath = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/bitmap";
        generate(inputPath,outputPath,lineNum);
        long time2 = new Date().getTime();
        System.out.println(time2-time1);
        System.out.println((time2-time1)/60);
    }

    public static void generate(String inputPath,String outputPath,int lineNum) throws IOException {

        FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for(int q =0;q<100;q++){
            FileWriter fileWriter =new FileWriter(outputPath+q+".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            HashMap<String, HashSet<Integer>> map= new HashMap<>();
            int num = 0;
            String str = null;
            //store the data file information in the map
            while((str=bufferedReader.readLine())!=null&&num<=lineNum){
                num++;
                String id = str.substring(0,8);
                //the key is id, the value is line num
                if(!map.containsKey(id)){
                    HashSet<Integer> set = new HashSet<>();
                    set.add(num);
                    map.put(id,set);
                }else{
                    HashSet set = map.get(id);
                    set.add(num);
                    map.put(id,set);
                }
            }

            //output the bitmap index file
            for(int a1=0;a1<10;a1++){
                for(int a2=0;a2<10;a2++){
                    for(int a3=0;a3<10;a3++){
                        for(int a4=0;a4<10;a4++){
                            for (int a5=0;a5<10;a5++){
                                for (int a6=0;a6<10;a6++){
                                    for (int a7=0;a7<10;a7++){
                                        for (int a8=0;a8<10;a8++){
                                            String opt = ""+a1+a2+a3+a4+a5+a6+a7+a8;
                                            //check existing the id
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
                                                //print a single line
                                                printWriter.println(opt+sb.toString());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            printWriter.close();
            fileWriter.close();
        }

        bufferedReader.close();
        fileReader.close();




    }
}
