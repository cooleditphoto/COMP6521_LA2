package Project_LA2;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class IDBitMapGenerator {

    /**
     * main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int lineNum = 10000;
        String inputPath1 = Configuration.path1;
        String outputPath = Configuration.tempContent;
        generate(inputPath1,outputPath,lineNum,0,2);
    }

    /**
     * bitmap generate method
     * @throws IOException
     */
    public  void start() throws IOException {
        int lineNum = 10000;
        String inputPath1 = Configuration.path1;
        String inputPath2 = Configuration.path2;
        String outputPath = Configuration.tempContent;


        generate(inputPath1,outputPath,lineNum,0,Configuration.fileTimes);
        generate(inputPath2,outputPath,lineNum,Configuration.fileTimes,2*Configuration.fileTimes);


        /*
        LineNum lineNum1 = new LineNum();
        int t1 = lineNum1.getLineNum(inputPath1);
        int num1 = t1%10000==0?t1/10000:t1/10000+1;

        int t2 = lineNum1.getLineNum(inputPath2);
        int num2 = t2%10000==0?t2/10000:t2/10000+1;

        generate(inputPath1,outputPath,lineNum,0,num1);
        generate(inputPath2,outputPath,lineNum,num1,num1+num2);
         */

    }

    /**
     * generate the bitmap file for eight-digit id number
     * @param inputPath
     * @param outputPath
     * @param lineNum
     * @param startNum
     * @param endNum
     * @throws IOException
     */
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
                //store the id information in a map
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
            //check 100000000 different number
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
