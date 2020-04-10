package Project_LA2;

import Util.DeleteFiles;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SmallFile {

    /**
     * main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        start();
        long time1 = new Date().getTime();
        mergeFile();
        long time2 = new Date().getTime();
        System.out.println(time2-time1);
    }

    /**
     * the whole process
     * @throws IOException
     */
    public static void start() throws IOException {
        long time1 = new Date().getTime();
        String originalPath1 = "/Users/wujiaqi/comp6521/smallfile/sameple3.txt";
        String originalPath2 = "/Users/wujiaqi/comp6521/smallfile/sameple4.txt";
        String phase1OutputPath1 ="/Users/wujiaqi/comp6521/smallfile/output1.txt";
        String phase1OutputPath2 ="/Users/wujiaqi/comp6521/smallfile/output2.txt";
        String phase2OutputPath1 ="/Users/wujiaqi/comp6521/smallfile/output3.txt";
        String phase2OutputPath2 ="/Users/wujiaqi/comp6521/smallfile/output4.txt";

        phase1(originalPath1,phase1OutputPath1);
        phase1(originalPath2,phase1OutputPath2);
        long time2 = new Date().getTime();
        System.out.println(time2-time1);
        phase2(originalPath1,phase1OutputPath1,phase2OutputPath1);
        phase2(originalPath2,phase1OutputPath2,phase2OutputPath2);
        long time3 = new Date().getTime();
        System.out.println(time3-time2);
        DeleteFiles deleteFiles = new DeleteFiles();
        deleteFiles.deleteFiles();
    }

    /**
     * generate bitmap files
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void phase1(String inputPath,String outputPath) throws IOException {

        FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter =new FileWriter(outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        HashMap<Integer, HashSet<Integer>> map= new HashMap<>();
        String str;

        int num=0;
        while((((str=bufferedReader.readLine())!=null))){
            num++;
            int id = Integer.parseInt(str.substring(0,8));
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
        bufferedReader.close();
        fileReader.close();
    }


    /**
     * change bitmap files into sorted data files
     * @param path
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void phase2(String path,String inputPath,String outputPath) throws IOException {
        FindRecord findRecord = new FindRecord();
        FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String str;

        while((str=bufferedReader.readLine())!=null){
            int num = 0;
            HashSet<String> set = new HashSet<>();
            for(int i=0;i<str.length();i++){
                num++;
                if(str.charAt(i)=='1'){
                    String s = findRecord.findRecordFromFile(path,num);
                    set.add(s);
                }
            }
            String res;
            if(set.size()>1){
                res = getMax(set);
            }else{
                Iterator it = set.iterator();
                res=  (String)it.next();
            }
            printWriter.println(res);
        }
        printWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }

    /**
     * get the latest line
     * @param set
     * @return
     */
    public static String getMax(HashSet<String> set){
        String res = "000000000000-00-00";
        Iterator it = set.iterator();
        while(it.hasNext()){
            String str = (String) it.next();
            if(str.substring(8,18).compareTo(res.substring(8,18))>0){
                res = str;
            }
        }
        return res;
    }


    /**
     * merge the sorted files
     * @throws IOException
     */
    public static void mergeFile() throws IOException {

        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory();
        int memoryListSize = (int) (totalMemory/Configuration.tupleSize /(Configuration.fileTimes*10) );

        MergeFiles mergeFiles = new MergeFiles();

        mergeFiles.start(Configuration.fileTimes*2,memoryListSize/2);

    }
}
