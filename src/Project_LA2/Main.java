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
        int ioNum1 = IDBitMapGenerator.io1%40==0?IDBitMapGenerator.io1/40:IDBitMapGenerator.io1/40+1;
        int ioNum2 = IDBitMapGenerator.io2%4000==0?(int)IDBitMapGenerator.io2/4000:(int)IDBitMapGenerator.io2/4000+1;
        int ioNum3 = ioNum1+ioNum2;
        //System.out.println("phase1 io: "+ioNum3);


        //phase2
        long time4 = new Date().getTime();
        MergePhase mergePhase = new MergePhase();
        mergePhase.start();
        //mergeFiles.start(totalMemory);
        long time5 = new Date().getTime();
        long time6 = time5-time4;
        System.out.println("phase2 time:"+ time6);
        int ioNum4 = MergePhase.io2%40==0?MergePhase.io2/40:MergePhase.io2/40+1;
        int ioNum5 = ioNum2+ioNum4;
        //System.out.println("phase3 io: "+ioNum6);

        //phase3
        long time7 = new Date().getTime();
        SmallFile smallFile = new SmallFile();
        smallFile.mergeFile();
        long time8 = new Date().getTime();
        long time9 = time8-time7;
        System.out.println("phase3 time: "+time9);
        //System.out.println("phase3 io: "+ioNum);

        long totalTime = time9+time6+time3;
        //result
        System.out.println("time for the whole process: "+totalTime);
        int totalIO = ioNum3+ ioNum4 + ioNum5;
        System.out.println("io times for the whose process: "+totalIO);


        //delete all files
        //deleteFiles.deleteFiles();

    }
}
