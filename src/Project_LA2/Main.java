package Project_LA2;

import Util.DeleteFiles;

import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        //get memory size
        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory();

        IDBitMapGenerator idBitMapGenerator = new IDBitMapGenerator();
        DeleteFiles deleteFiles = new DeleteFiles();

        System.out.println ("total memory:"+ totalMemory/1024/1024+"M");

        //phase1
        long time1 = new Date().getTime();
        idBitMapGenerator.start();
        long time2 = new Date().getTime();
        long time3 = time2-time1;
        System.out.println("phase1 time: "+time3);
        System.out.println("phase1 io: "+IDBitMapGenerator.io);


        //phase2
        long time4 = new Date().getTime();
        MergePhase mergePhase = new MergePhase();
        mergePhase.start();
        //mergeFiles.start(totalMemory);
        long time5 = new Date().getTime();
        long time6 = time5-time4;
        System.out.println("phase2 time:"+ time6);
        System.out.println("phase2 io: "+ MergePhase.io);

        //phase3
        long time7 = new Date().getTime();
        SmallFile smallFile = new SmallFile();
        smallFile.mergeFile();
        long time8 = new Date().getTime();
        long time9 = time8-time7;
        System.out.println("phase3 time: "+time9);
        System.out.println("phase3 io: "+MergeOperation.io);

        long totalTime = time9+time6+time3;
        //result
        System.out.print("time for the whole process: "+totalTime);
        int totalIO = IDBitMapGenerator.io+ MergePhase.io+MergeOperation.io;
        System.out.println("io times for the whose process: "+totalIO);


        //delete all files
        //deleteFiles.deleteFiles();

    }
}
