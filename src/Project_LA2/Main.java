package Project_LA2;

import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        Phase2 phase2 = new Phase2();

        //get memory size
        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory();
        System.out.println ("total memory:"+ totalMemory/1024/1024+"M");

        //step2
        Date date3 = new Date();
        phase2.start(totalMemory);
        Date date4 = new Date();
        long file_time2;
        file_time2 = date4.getTime()-date3.getTime();
        System.out.println("phase2 time:"+ file_time2);


    }
}
