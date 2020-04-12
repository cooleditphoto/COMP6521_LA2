package Project_LA2;

import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class MergePhase {

    static int io1 = 0;
    static int io2= 0;
    /**
     * main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        start();
    }


    /**
     * bitmap file merge phase
     * @throws IOException
     */
    public static void start() throws IOException {
        String path1 = Configuration.path1;
        String path2 = Configuration.path2;
        generate(path1,0,100);
        generate(path2,100,150);
    }

    /**
     * generate sorted files
     * @param path
     * @param start
     * @param end
     * @throws IOException
     */
    public static void generate(String path,int start,int end) throws IOException {
        FindRecord findRecord = new FindRecord();

        for(int t=start;t<end;t++){
            String path1  = Configuration.tempContent+t+".txt";
            FileReader fileReader = new FileReader(path1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(Configuration.tempContent2+t+".txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String str;

            while((str=bufferedReader.readLine())!=null){
                io1++;
                int num = 0;
                HashSet<String> set = new HashSet<>();
                for(int i=0;i<str.length();i++){
                    num++;
                    if(str.charAt(i)=='1'){
                        String s = findRecord.findRecordFromFile(path,(t-start)*10000+num);
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
                io2++;
            }
            printWriter.close();
            fileWriter.close();
            bufferedReader.close();
            fileReader.close();
        }
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
}
