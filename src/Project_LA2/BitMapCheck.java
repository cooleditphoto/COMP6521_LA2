package Project_LA2;

import Project_LA2.FindRecord;
import Project_LA2.MergeFiles;

import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class BitMapCheck {
    public static void main(String[] args) throws IOException {
        long time1 = new Date().getTime();
        FindRecord findRecord = new FindRecord();
        String path2 = Configuration.path1;
        String path3 = Configuration.path2;
        for(int p=0;p<100;p++){
            String path  = Configuration.tempContent+p+".txt";
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(Configuration.tempContent2+p+".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String str;

            while((str=bufferedReader.readLine())!=null){
                int num = 0;
                HashSet<String> set = new HashSet<>();
                for(int i=0;i<str.length();i++){
                    num++;
                    if(str.charAt(i)=='1'){
                        String s = findRecord.findRecordFromFile(path2,p*10000+num);
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
        for(int p=100;p<150;p++){
            String path  = Configuration.tempContent+p+".txt";
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(Configuration.tempContent2+p+".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String str;

            while((str=bufferedReader.readLine())!=null){
                int num = 0;
                HashSet<String> set = new HashSet<>();
                for(int i=0;i<str.length();i++){
                    num++;
                    if(str.charAt(i)=='1'){
                        String s = findRecord.findRecordFromFile(path3,(p-100)*10000+num);
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

        MergeFiles mergeFiles = new MergeFiles();
        Runtime rt = Runtime.getRuntime();
        mergeFiles.start(rt.totalMemory());

        long time2 = new Date().getTime();
        System.out.println(time2-time1);
    }

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
}
