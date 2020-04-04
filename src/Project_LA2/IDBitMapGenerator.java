package Project_LA2;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class IDBitMapGenerator {

    public static void main(String[] args) throws IOException {
        int lineNum = 10000;
        String inputPath1 = Configuration.TEST_PATH;
        String outputPath = Configuration.TEMP_CONTENT;
        generate(inputPath1,outputPath,lineNum,0,100);
    }

    public  void start() throws IOException {
        int lineNum = 10000;
        String inputPath1 = Configuration.TEST_PATH;
        String inputPath2 = Configuration.TEST_PATH2;
        String outputPath = Configuration.TEMP_CONTENT;
        generate(inputPath1,outputPath,lineNum,0,100);
        generate(inputPath2,outputPath,lineNum,100,150);

    }

    public static void generate(String inputPath,String outputPath,int lineNum,int startNum,int endNum) throws IOException {

        FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        for(int q =startNum;q<endNum;q++){
            FileWriter fileWriter =new FileWriter(outputPath+q+".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            HashMap<Integer, HashSet<Integer>> map= new HashMap<>();
            int num = 0;
            String str = null;
            while(( (num<lineNum)&&(str=bufferedReader.readLine())!=null)){
                num++;
                Integer id = Integer.parseInt(str.substring(0,8));
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
            for(int i=0;i<100000000;i++){
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
                    //print a single line
                    printWriter.println(sb.toString());
                }
            }
            printWriter.close();
            fileWriter.close();
        }
        bufferedReader.close();
        fileReader.close();
    }
}
