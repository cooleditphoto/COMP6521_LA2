package Project_LA2;

import Util.DeleteFiles;

import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        //MergeFiles mergeFiles = new MergeFiles();
        IDBitMapGenerator idBitMapGenerator = new IDBitMapGenerator();
        DeleteFiles deleteFiles = new DeleteFiles();

        //get memory size
        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory();
        System.out.println ("total memory:"+ totalMemory/1024/1024+"M");

        //bitmap generate phase
        long time1 = new Date().getTime();
        idBitMapGenerator.start();
        long time2 = new Date().getTime();
        long time = time2-time1;
        System.out.println("bitmap generate time:"+time);

        //bitmap file merge phase
        Date date3 = new Date();
        MergePhase mergePhase = new MergePhase();
        mergePhase.start();
        //mergeFiles.start(totalMemory);
        Date date4 = new Date();
        long time3;
        time3 = date4.getTime()-date3.getTime();
        System.out.println("bitmap files merge time:"+ time3);
        long totalTime = time3+time;
        //result
        System.out.print("time for the whole process:"+totalTime);

        //delete all files
        //deleteFiles.deleteFiles();

    }
}
